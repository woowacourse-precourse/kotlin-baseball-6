package baseball.controller

import baseball.model.Balls
import baseball.model.BaseballGameModel
import baseball.model.Score
import baseball.view.BaseballGameView
import camp.nextstep.edu.missionutils.Randoms

class BaseballGameController(private val view: BaseballGameView, private val model: BaseballGameModel) {
    fun run() {
        view.printStartMessage()
        while (!model.isExit) {
            playGame()
            val userInput = view.inputGameExit()
            model.isExit = checkIsExit(userInput = userInput)
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

    private fun checkIsExit(userInput: Int): Boolean {
        require(userInput in 1 until 3) { "$userInput 1 또는 2가 아닙니다." }

        return if (userInput == 2) {
            view.printExitMessage()
            true
        } else {
            model.reset()
            false
        }
    }

}