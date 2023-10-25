package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var secretNumber = generateSecretNumber()
    var attempts = 0

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val guess = getUserGuess()
        attempts++

        val result = checkGuess(secretNumber, guess)
        println("$result")

        if (result == "3스트라이크") {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            if (playAgain()) {
                attempts = 0
                secretNumber = generateSecretNumber()
            } else {
                return
            }
        }
    }
}

fun generateSecretNumber(): String {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers.joinToString("")
}

fun getUserGuess(): String {
    while (true) {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        if (input.matches(Regex("[1-9]{3}"))) {
            return input
        } else {
            throw IllegalArgumentException()
        }
    }
}

fun checkGuess(secret: String, guess: String): String {
    var strikes = 0
    var balls = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            strikes++
        } else if (secret.contains(guess[i])) {
            balls++
        }
    }

    return when {
        strikes == 3 -> "3스트라이크"
        strikes > 0 || balls > 0 -> "${balls}볼 ${strikes}스트라이크"
        else -> "낫싱"
    }
}

fun playAgain(): Boolean {
    while (true) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = Console.readLine()
        if (input.equals("1")) {
            return true
        } else if (input.equals("2")) {
            return false
        } else {
            return false
        }
    }
}
