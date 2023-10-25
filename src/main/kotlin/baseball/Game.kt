package baseball

import baseball.ErrorMessage.BOUND_ERROR
import baseball.GameMessage.RESTART_MESSAGE
import camp.nextstep.edu.missionutils.Console

class Game(
    private val computerNumberGenerator: ComputerNumberGenerator,
    private val userInput: UserInput,
    private val scoreCalculator: BaseballScoreCalculator,
) {

    fun start() {
        val computerList = computerNumberGenerator.getNumberList()
        do {
            val userList = userInput.getNumberList()
            val score = scoreCalculator.calculate(computerList, userList)
            score.toMessage()
        } while (!isGameEnd(computerList, userList))
    }

    fun isRestart(): Boolean {
        println(RESTART_MESSAGE)

        return when (Console.readLine()) {
            RESTART -> true
            END -> false
            else -> throw IllegalArgumentException(BOUND_ERROR)
        }
    }

    private fun isGameEnd(computerList: List<Int>, userList: List<Int>): Boolean = computerList == userList

    companion object {
        private const val RESTART = "1"
        private const val END = "2"
    }
}
