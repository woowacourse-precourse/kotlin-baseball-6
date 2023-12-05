package baseball.controller

import baseball.model.MatchUp
import baseball.model.PlayingNumber
import baseball.model.Score
import baseball.view.InputView
import baseball.view.OutputView

class Controller(
        private val inputView: InputView,
        private val outputView: OutputView
) {

    fun process() {
        outputView.printStartMessage()
        val computerNumber = PlayingNumber.pitchBall()
        val matchUp = MatchUp(computerNumber)
        while (true) {
            val userNumber = inputView.readNumbers()
            val score = matchUp.play(userNumber)

            if (score.isStrike()) {
                outputView.printEndMessage()
                break
            }
            printResult(score)
        }
    }

    private fun printResult(score: Score) {
        if (score.isNothing()) {
            outputView.printNothing()
            return
        }
        outputView.printResult(ball = score.balls, strike = score.strikes)
    }

}
