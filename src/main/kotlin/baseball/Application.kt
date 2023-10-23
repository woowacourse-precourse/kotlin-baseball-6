package baseball

import kotlin.random.Random

fun main() {
    var continueGame = true

    while (continueGame) {
        val target = generateTarget()
        var guess: String
        var result: Pair<Int, Int> = Pair(0, 0) // 초기화

        do {
            print("숫자를 입력해주세요: ")
            guess = readLine() ?: ""
            if (!isValidInput(guess)) {
                println("Invalid input. Please enter a 3-digit number with distinct digits.")
                continue
            }

            result = checkGuess(guess, target)

            when {
                result.first == 0 && result.second == 0 -> println("낫싱")
                else -> println("${result.first} 스트라이크, ${result.second} 볼")
            }
        } while (result.first < 3)

        println("축하합니다! 숫자를 맞추셨습니다.")

        print("게임을 다시 시작하려면 '1'을, 종료하려면 '2'를 입력하세요: ")

        when(readLine()) {
            "1" -> continueGame = true
            "2" -> continueGame = false
            else -> {
                println("잘못된 선택입니다. 게임을 종료합니다.")
                continueGame = false
            }
        }
    }

}

fun generateTarget(): String {
    val numbers = MutableList(9) { it + 1 }
    numbers.shuffle()

    return buildString {
        for (i in 0 until 3) append(numbers[i])
    }
}

fun isValidInput(input: String): Boolean =
    input.length == 3 && input.toSet().size == input.length

fun checkGuess(guess: String, target: String): Pair<Int, Int> {
    var strikes = 0
    var balls = 0

    for (i in guess.indices) {
        if (guess[i] == target[i]) strikes++
        else if (target.contains(guess[i])) balls++
    }

    return Pair(strikes, balls)
}