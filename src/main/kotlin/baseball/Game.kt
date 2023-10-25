// baseball/Game.kt
package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    private val randomThreeDigit = mutableListOf<Int>()
    private var playing = true

    data class Result(val strike: Int, val ball: Int)

    fun start() {
        println("숫자 야구 게임을 시작합니다.")
        generateRandomNumbers()
        while (playing) {
            val userInput: List<Int> = readUserInput()
            val result: Result = checkUserInput(userInput)
            printGameResult(result)
            if (result.strike == 3) {
                endGame()
            }
        }
    }

    private fun generateRandomNumbers() {
        while (randomThreeDigit.size < 3) {
            val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
            if (!randomThreeDigit.contains(randomNumber)) {
                randomThreeDigit.add(randomNumber)
            }
        }
    }

    private fun readUserInput(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val userInput: String = Console.readLine()
        validateUserInput(userInput)
        return userInput.map { it.toString().toInt() }
    }

    private fun validateUserInput(userInput: String) {
        when {
            userInput.length != 3 -> {
                throw IllegalArgumentException("3자리 수를 입력해야함")
            }
            !userInput.all { it in '1'..'9' } -> {
                throw IllegalArgumentException("1~9까지의 수를 입력해야함")
            }
            userInput.toSet().size != 3 -> {
                throw IllegalArgumentException("각 자리의 수는 서로 다른 숫자로 이루어져야함")
            }
        }
    }

    private fun checkUserInput(userInput: List<Int>): Result {
        var strike = 0
        var ball = 0
        for (i in userInput.indices) {
            if (userInput[i] == randomThreeDigit[i]) {
                strike++
            } else if (userInput[i] in randomThreeDigit) {
                ball++
            }
        }
        return Result(strike, ball)
    }

    private fun printGameResult(result: Result) {
        if (result.strike == 0 && result.ball == 0) {
            println("낫싱")
            return
        }
        val hint = buildString {
            if (result.ball > 0 && result.strike> 0) {
                append("${result.ball}볼 ${result.strike}스트라이크")
            }else {
                if (result.ball > 0) {
                    append("${result.ball}볼")
                }
                if (result.strike > 0) {
                    append("${result.strike}스트라이크")
                }
            }

        }
        println(hint)
    }

    private fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = Console.readLine()
        when (userInput) {
            "1" -> startNewGame()
            "2" -> quitGame()
            else -> throw IllegalArgumentException("1 또는 2를 입력해야함")
        }
    }

    private fun startNewGame() {
        randomThreeDigit.clear()
        generateRandomNumbers()
    }

    private fun quitGame() {
        playing = false
    }
}
