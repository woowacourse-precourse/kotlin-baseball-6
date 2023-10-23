package baseball.app

import baseball.controller.GameController
import baseball.model.Balls
import baseball.model.Score
import baseball.view.ScreenView

class BaseballGame {
    private val view = ScreenView()
    private val controller = GameController(view = view)
    private val computerBalls: Balls = controller.getRandomBalls()
    private var isEnd: Boolean = false
    fun run() {
        view.printStartMessage()
        while (!this.isEnd){
            val userBalls: Balls = controller.inputUserBalls()
            val score: Score = controller.calculateScore(userBalls = userBalls, computerBalls = computerBalls)
            checkIsEnd(score = score)
            view.printScore(score = score)
        }
    }

    fun checkIsEnd(score: Score) {
        if (score.strike == Balls.MAX_BALLS) {
            this.isEnd = true
            view.printEndMessage()
        }
    }

}