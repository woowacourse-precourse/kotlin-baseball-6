package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    runGame()
}

fun runGame() {
    var continueGame = true

    while (continueGame) {
        val target = generateTarget()
        var guess: String
        var result: Pair<Int, Int> = Pair(0, 0)

        do {
            println("숫자 야구 게임을 시작합니다.")
            println("숫자를 입력해주세요: ")
            guess = Console.readLine()
            if (!isValidInput(guess)) {
                throw IllegalArgumentException("Invalid input. Please enter a 3-digit number with distinct digits.")
            }

            result = checkGuess(guess, target)

            when {
                result.first == 0 && result.second == 0 -> println("낫싱")
                else -> println("${result.second}볼 ${result.first}스트라이크")
            }
        } while (result.first < 3)

        println("축하합니다! 숫자를 맞추셨습니다.")

        println("게임을 다시 시작하려면 '1'을, 종료하려면 '2'를 입력하세요: ")

        when(Console.readLine()) {
            "1" -> continueGame = true
            "2" -> {
                continueGame = false
                println("게임 종료") // 게임 종료 메시지 추가
            }
            else -> {
                throw IllegalArgumentException("잘못된 선택입니다. 게임을 종료합니다.")
                continueGame = false
            }
        }
    }
}

fun generateTarget(): String {
    val numbers = mutableListOf<Int>()

    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }

    return numbers.joinToString(separator="")
}

fun isValidInput(input: String): Boolean {
    if (input.length != 3 || input.toSet().size != input.length) {
        return false
    }

    for (char in input) {
        val digit = char.toString().toIntOrNull()
        if (digit == null || digit < 1 || digit > 9) {
            return false
        }
    }

    return true
}

fun checkGuess(guess: String, target: String): Pair<Int, Int> {
    var strikes = 0
    var balls = 0

    for (i in guess.indices) {
        if (guess[i] == target[i]) {
            strikes++
        } else if (target.contains(guess[i])) {
            balls++
        }
    }

    return Pair(strikes, balls)
}