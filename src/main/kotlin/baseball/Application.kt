package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    OutputWriter().printGameStart()
    while (true) {
        val game = NumberBaseballGame()
        val result = game.start()
        if (result == NumberBaseballGame.END) break
    }
}

class NumberBaseballGame {

    private val output = OutputWriter()
    private val computer = generateRandomNumbers()

    fun start(): String {
        while (true) {
            val user = inputUserNumbers()
            val (ball, strike) = compareGuess(user)
            output.printGuessResult(ball, strike)

            if (strike == 3) {
                output.printGameEnd()
                break
            }
        }
        return inputGameFlowDecision()
    }

    private fun inputGameFlowDecision(): String {
        output.printReceiveGameFlowInput()
        return Console.readLine().also {
            if (it != RESTART && it != END) throw IllegalArgumentException()
        }
    }

    private fun inputUserNumbers(): List<Int> {
        output.printReceiveNumberInput()
        val input = Console.readLine()
        validateUserInput(input)
        return input.map { it.toString().toInt() }
    }

    private fun validateUserInput(input: String) {
        require(input.length == 3) { throw IllegalArgumentException() }
        require(input.toSet().size == 3) { throw IllegalArgumentException() }
        require(input.all { it in '1'..'9' }) { throw IllegalArgumentException() }
    }

    private fun generateRandomNumbers(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    private fun compareGuess(user: List<Int>): Pair<Int,Int> {
        var strike = 0
        var ball = user.count { it in computer }

        for (i in user.indices) {
            if (user[i] == computer[i]) {
                strike++
                ball--
            }
        }
        return ball to strike
    }

    companion object {
        const val RESTART = "1"
        const val END = "2"
    }
}

class OutputWriter {
    fun printGameStart() = println("숫자 야구 게임을 시작합니다.")
    fun printGameEnd() = println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    fun printReceiveNumberInput() = print("숫자를 입력해주세요 : ")
    fun printReceiveGameFlowInput() = println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    fun printGuessResult(ball: Int, strike: Int) {
        when {
            ball == 0 && strike == 0 -> printNothingResult()
            ball >0 && strike == 0 -> printOnlyBalls(ball)
            ball == 0 && strike > 0 -> printOnlyStrikes(strike)
            else -> printBallAndStrike(ball, strike)
        }
    }

    private fun printNothingResult() = println("낫싱")
    private fun printOnlyBalls(ball: Int) = println("${ball}볼")
    private fun printOnlyStrikes(strike: Int) = println("${strike}스트라이크")
    private fun printBallAndStrike(ball: Int, strike: Int) = println("${ball}볼 ${strike}스트라이크")
}
