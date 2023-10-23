package baseball.controller

import baseball.domain.BaseBallGame
import baseball.domain.ChoiceState
import baseball.domain.CompareNumbers
import baseball.domain.GameResult
import baseball.view.PrintResultView
import baseball.view.ReadNumberView
import baseball.view.ReadUserRestartChoiceView

class BaseBallGameController(
    private val inputNumberView: ReadNumberView,
    private val inputChoiceView: ReadUserRestartChoiceView,
    private val resultView: PrintResultView,
    private val compareNumbers: CompareNumbers
) {
    fun play() {
        val baseBallGame = BaseBallGame()
        while (baseBallGame.getGameState() != ChoiceState.Exit) {
            while (baseBallGame.isPlaying() == GameResult.Lose) {
                val userNumber = inputNumberView.readUserInput()
                val gameResult = baseBallGame.playGame(userNumber, compareNumbers)
                resultView.printGameResult(gameResult)

            }
            val restartState = inputChoiceView.readUserInput()
            if (restartState == ChoiceState.Restart.stateCode) {
                baseBallGame.restartGame()
            } else {
                baseBallGame.exitGame()
            }
        }
    }

}