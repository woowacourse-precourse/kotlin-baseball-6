package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    private var computerNumbers = mutableListOf<Int>()

    fun startGame() {
        do {
            resetGame()
            try {
                play()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return
            }
        } while (restart())
        println("게임을 종료합니다.")
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

    fun play() {
        while (true) {
            val userInput = getUserInput()
            val strikes = countStrikes(userInput)
            val balls = countBalls(userInput)

            if (strikes == 3) {
                println("3스트라이크")
                println("정답입니다!")
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
        var strikeCount = 0
        for (i in 0..2) {
            if (computerNumbers[i] == userInput[i]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    private fun countBalls(userInput: List<Int>): Int {
        var ballCount = 0
        for (i in 0..2) {
            if (userInput[i] in computerNumbers && userInput[i] != computerNumbers[i]) {
                ballCount++
            }
        }
        return ballCount
    }

    private fun restart(): Boolean {
        while (true) {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
            val input = Console.readLine()
            when (input) {
                "1" -> return true
                "2" -> return false
                else -> println("잘못된 입력입니다. 다시 입력해주세요.")
            }
        }
    }

    private fun getUserInput(): List<Int> {
        print("숫자를 입력해 주세요 : ")
        val input = Console.readLine()
        return checkUserInput(input)
    }

    private fun checkUserInput(input: String): List<Int> {
        if (!isValid(input)) {
            throw IllegalArgumentException("잘못된 입력입니다. 1에서 9까지 서로 다른 수 3개를 입력해 주세요.")
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