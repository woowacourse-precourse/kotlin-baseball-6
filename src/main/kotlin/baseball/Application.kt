package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var playAgain = true

    while (playAgain) {
        playGame()

        println("게임을 다시 시작하려면 1을, 종료하려면 2를 입력하세요.")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                println("게임을 다시 시작합니다.")
            }
            2 -> {
                println("게임을 종료합니다. 감사합니다!")
                playAgain = false
            }
            else -> {
                println("올바른 선택이 아닙니다. 게임을 종료합니다.")
                playAgain = false
            }
        }
    }
}

fun playGame() {
    val secretNumber = generateSecretNumber()
    var attempts = 0

    println("숫자야구 게임을 시작합니다.")

    while (true) {
        val userGuess = readUserGuess()
        attempts++

        try {
            validateUserGuess(userGuess)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            break
        }

        val result = compareNumbers(secretNumber, userGuess)
        println("결과: $result")

        if (result == "3스트라이크") {
            println("정답입니다! $attempts 번만에 맞췄습니다.")
            break
        }
    }
}

fun validateUserGuess(userGuess: String) {
    if (userGuess.length != 3) {
        throw IllegalArgumentException("3자리 숫자만 입력 가능합니다.")
    }

    val uniqueDigits = userGuess.toSet()
    if (uniqueDigits.size != 3) {
        throw IllegalArgumentException("중복되지 않는 숫자만 입력 가능합니다.")
    }

    if (userGuess.any { it !in '1'..'9' }) {
        throw IllegalArgumentException("1~9 사이의 숫자만 입력 가능합니다.")
    }
}

fun generateSecretNumber(): String {
    val uniqueDigits = mutableListOf<Int>()

    while (uniqueDigits.size < 3) {
        val digit = Randoms.pickNumberInRange(1, 9)
        if (!uniqueDigits.contains(digit)) {
            uniqueDigits.add(digit)
        }
    }

    return uniqueDigits.joinToString("")
}

fun readUserGuess(): String {
    print("숫자를 입력하세요: ")
    return Console.readLine()
}

fun compareNumbers(secret: String, guess: String): String {
    var strike = 0
    var ball = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            strike++
        } else if (secret.contains(guess[i])) {
            ball++
        }
    }

    return when {
        strike == 3 -> "3스트라이크"
        strike > 0 || ball > 0 -> "$strike 스트라이크 $ball 볼"
        else -> "낫싱"
    }
}