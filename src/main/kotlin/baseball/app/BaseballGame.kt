package baseball.app

import baseball.controller.GameController
import baseball.model.Balls
import baseball.model.Score
import baseball.view.ScreenView

class BaseballGame {
    private val view = ScreenView()
    private val controller = GameController(view = view)
    private var computerBalls: Balls = controller.getRandomBalls()
    private var isExit: Boolean = false
    fun run() {
        view.printStartMessage()
        while (!isExit) {
            playGame()
            val userInput = view.inputGameExit()
            isExit = checkIsExit(userInput = userInput)
        }

    }

    private fun playGame() {
        var isGameEnd = false
        while (!isGameEnd) {
            val userBalls: Balls = controller.inputUserBalls()
            val score: Score = controller.calculateScore(userBalls = userBalls, computerBalls = computerBalls)
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
            reset()
            false
        }
    }

    private fun reset() {
        computerBalls = controller.getRandomBalls()
    }
}