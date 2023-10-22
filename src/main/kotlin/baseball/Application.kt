package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    private var computerNumbers = mutableListOf<Int>()

    fun startGame() {
        do {
            resetGame()
            playGame()
        } while (restart())
        println("게임 종료")
    }


    private fun resetGame() {
        computerNumbers = mutableListOf()
        generateComputer()
    }

    private fun generateComputer() {
        while (computerNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in computerNumbers) {
                computerNumbers.add(randomNumber)
            }
        }
    }

    private fun playGame() {
        while (true) {
            val userInput = getUserInput()
            val strikes = countStrikes(userInput)
            val balls = countBalls(userInput)

            if (strikes == 3) {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }

            if (strikes > 0 && balls > 0) {
                println("${balls}볼 ${strikes}스트라이크")
            } else if (strikes > 0) {
                println("${strikes}스트라이크")
            } else if (balls > 0) {
                println("${balls}볼")
            } else {
                println("낫싱")
            }
        }
    }

    private fun countStrikes(userInput: List<Int>): Int {
        return userInput.zip(computerNumbers).count { (user, computer) -> user == computer }
    }

    private fun countBalls(userInput: List<Int>): Int {
        return userInput.count { it in computerNumbers } - countStrikes(userInput)
    }

    private fun restart(): Boolean {
        while (true) {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
            return when (Console.readLine()) {
                "1" -> true
                "2" -> false
                else -> throw IllegalArgumentException("잘못된 입력값입니다.")
            }
        }
    }

    private fun getUserInput(): List<Int> {
        print("숫자를 입력해 주세요 : ")
        val input = Console.readLine()

        if (!isValid(input)) {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }

        return checkUserInput(input)
    }


    private fun checkUserInput(input: String): List<Int> {
        if (!isValid(input)) {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }
        return input.map { it.toString().toInt() }
    }


    private fun isValid(input: String): Boolean {
        return input.length == 3 &&
                input.all { it in '1'..'9' } &&
                input.toSet().size == 3
    }
}

fun main() {
    val baseballGame = BaseballGame()

    println("숫자 야구 게임을 시작합니다.")
    baseballGame.startGame()
}