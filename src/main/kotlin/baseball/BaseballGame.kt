package baseball

import util.Constants
import util.RandomNumbersGenerator
import util.UserConsole.getValidInput
import util.UserConsole.getValidRestartInput

class BaseballGame {

    fun start() {
        println(Constants.START_MESSAGE)
        do {
            playRound()
        } while (isRestartable())
    }

    private fun playRound() {
        val answerNumbers = RandomNumbersGenerator.create(3, 1, 9)
        do {
            val userNumbers = getValidInput()
            val scoring = BaseballScoring()
            val (strikeCount, ballCount) = scoring.calculateScore(answerNumbers, userNumbers)
            scoring.printScore(strikeCount, ballCount)
        } while (!isSame(answerNumbers, userNumbers))
        println(Constants.SUCCESS_MESSAGE)
    }

    private fun isRestartable(): Boolean {
        println(Constants.RESTART_MESSAGE)
        return ("1" == getValidRestartInput())
    }

    private fun isSame(answer: List<Int>, user: List<Int>) = answer == user
}