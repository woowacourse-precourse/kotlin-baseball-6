package baseball.controller

import baseball.domain.BallCountResult
import baseball.domain.BaseBallGame
import baseball.domain.ChoiceState
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
        while (gameResult.countStrike() != 3) {
            val userInputNumbers = inputNumberView.readUserNumberInput()
            gameResult = baseBallGame.playGame(userInputNumbers)
            resultView.printGameResult(gameResult)

        }
        val restartStateInput = inputNumberView.readUserRestartInput()
        return baseBallGame.restartChoice(restartStateInput)


    }

}