package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    while (true) {
        val computerNumbers = generateComputerNumbers()
        println("숫자 야구 게임을 시작합니다.")

        var attempts = 0

        while (true) {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()

            try {
                val userNumbers = userInput.split("").mapNotNull { it.toIntOrNull() }

                if (userNumbers.size != 3 || userNumbers.any { it < 1 || it > 9 }) {
                    throw IllegalArgumentException()
                }

                val result = evaluateGuess(userNumbers, computerNumbers)
                printResult(result)

                attempts++

                if (result.strikes == 3) {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    break
                }

            } catch (e: IllegalArgumentException) {
                exitProcess(0)
            }
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = Console.readLine()

        if (choice == "2") {
            break
        }
    }

    println("게임을 종료합니다.")
}

data class GuessResult(val strikes: Int, val balls: Int)

fun evaluateGuess(userNumbers: List<Int>, computerNumbers: List<Int>): GuessResult {
    var strikes = 0
    var balls = 0

    for (i in userNumbers.indices) {
        if (userNumbers[i] == computerNumbers[i]) {
            strikes++
        } else if (userNumbers[i] in computerNumbers) {
            balls++
        }
    }

    return GuessResult(strikes, balls)
}

fun generateComputerNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun printResult(result: GuessResult) {
    if (result.balls > 0) {
        print("${result.balls}볼 ")
    }
    if (result.strikes > 0) {
        print("${result.strikes}스트라이크 ")
    }
    if (result.strikes == 0 && result.balls == 0) {
        print("낫싱 ")
    }
    println()
}