package baseball.controller

import baseball.domain.*
import baseball.view.PrintResultView
import baseball.view.ReadNumberView
import baseball.view.ReadUserRestartChoiceView

class BaseBallGameController(
    private val inputNumberView: ReadNumberView,
    private val inputChoiceView: ReadUserRestartChoiceView,
    private val resultView: PrintResultView,
    private val compareNumbers: CompareNumbers,
    private val numberValidator: ValidateUserInput
) {
    fun play() {
        val baseBallGame = BaseBallGame()
        while (baseBallGame.getGameState() != ChoiceState.Exit) {
            while (baseBallGame.isPlaying() == GameResult.Lose) {
                val userNumberInput = inputNumberView.readUserNumberInput()
                val userNumber = numberValidator.validateNumber(userNumberInput)
                val gameResult = baseBallGame.playGame(userNumber, compareNumbers)
                resultView.printGameResult(gameResult)

            }
            val restartStateInput = inputChoiceView.readUserRestartInput()
            val restartState = numberValidator.validateRestart(restartStateInput)
            if (restartState == ChoiceState.Restart) {
                baseBallGame.restartGame()
            } else {
                baseBallGame.exitGame()
            }
        }
    }

}