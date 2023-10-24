package baseball.controller

import baseball.constant.ChoiceState
import baseball.domain.BallCountResult
import baseball.service.BaseBallGame
import baseball.view.PrintOutputView
import baseball.view.ReadUserInputView

class BaseBallGameController(
    private val inputNumberView: ReadUserInputView,
    private val resultView: PrintOutputView
) {
    fun play() {
        val baseBallGame = BaseBallGame()
        resultView.printStartGame()
        while (true) {
            if (playGame(baseBallGame) == ChoiceState.EXIT) break
            baseBallGame.restartGame()
        }
    }

    private fun playGame(baseBallGame: BaseBallGame): ChoiceState {
        var gameResult = BallCountResult()
        while (gameResult.countStrike() != FULL_STRIKE_COUNT) {
            resultView.printRequireNumber()
            val userInputNumbers = inputNumberView.readUserNumberInput()
            gameResult = baseBallGame.playGame(userInputNumbers)
            resultView.printGameResult(gameResult)

        }
        resultView.printRequireRestart()
        val restartStateInput = inputNumberView.readUserRestartInput()
        return baseBallGame.restartChoice(restartStateInput)


    }

    companion object {
        private const val FULL_STRIKE_COUNT = 3
    }
}