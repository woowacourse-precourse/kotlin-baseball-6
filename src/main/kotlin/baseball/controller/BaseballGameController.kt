package baseball.controller

import baseball.model.Balls
import baseball.model.BaseballGameModel
import baseball.model.Score
import baseball.view.BaseballGameView

class BaseballGameController(private val view: BaseballGameView, private val model: BaseballGameModel) {
    fun run() {
        view.printStartMessage()
        while (!model.isExit) {
            playGame()
            checkIsExit(userInputIsExit = view.inputGameExit())
        }
    }

    private fun playGame() {
        var isGameEnd = false
        while (!isGameEnd) {
            val userBalls: Balls = view.inputUserBalls()
            val score: Score = model.calculateScore(userBalls = userBalls)
            view.printScore(score = score)
            isGameEnd = checkIsEnd(score = score)
        }

    }

    private fun checkIsEnd(score: Score): Boolean {
        return if (score.strike == Balls.MAX_BALLS) {
            view.printEndMessage()
            true
        } else {
            false
        }
    }

    private fun checkIsExit(userInputIsExit: Boolean) {
        if (!userInputIsExit) {
            model.reset()
        } else {
            view.printExitMessage()
            model.isExit = true
        }
    }
}