package baseball.service

import baseball.model.BaseballGame
import baseball.model.GameState
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGameService() {

    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    fun start() {
        val baseballGame = BaseballGame()
        outputView.printGameStartMessage()
        while (baseballGame.state != GameState.EXIT) {
            when (baseballGame.state) {
                GameState.START -> {
                    baseballGame.computer.makeRandomNumbers()
                    baseballGame.state = GameState.RUN
                }

                GameState.RUN -> {
                    outputView.printGameInputMessage()
                    baseballGame.user.setNumber(inputView.getInputNumber())
                    val score = baseballGame.getScore()
                    outputView.printGameScoreMessage(score)
                    if (score.strike == 3) {
                        outputView.printGameSuccessMessage()
                        baseballGame.state = GameState.END
                    }
                }

                GameState.END -> {
                    outputView.printGameEndMessage()
                    when (inputView.getRestartOption()) {
                        1 -> {
                            baseballGame.state = GameState.START
                        }

                        2 -> {
                            baseballGame.state = GameState.EXIT
                        }
                    }
                }
                else -> break
            }
        }
    }
}