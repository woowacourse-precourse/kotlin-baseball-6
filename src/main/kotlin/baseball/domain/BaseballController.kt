package baseball.domain

import baseball.domain.BaseballGame
import baseball.model.GameStatus
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView(), private val baseballGame: BaseballGame = BaseballGame()) {

    fun run() {
        var randomNumber = ""
        var gameStatus = GameStatus.GAME_START
        outputView.printGameStartMessage()

        while (gameStatus != GameStatus.GAME_OVER) {
            when (gameStatus) {
                GameStatus.GAME_START -> {
                    randomNumber = baseballGame.generateRandomNumber()
                    gameStatus = GameStatus.GAME_IN_PROGRESS
                }

                GameStatus.GAME_IN_PROGRESS -> {
                    gameStatus = processGameInProgress(randomNumber, gameStatus)
                }
                else -> break
            }
        }
    }

    private fun processGameInProgress(randomNumber: String, gameStatus: GameStatus): GameStatus {
        outputView.printNumberInputMessage()
        val userInput = inputView.getInputNumber()
        val score = baseballGame.calculateScore(randomNumber, userInput)
        outputView.printScoreMessage(score)

        if (baseballGame.isCorrectAnswer(randomNumber, userInput)) {
            outputView.printGameSuccessMessage()
            outputView.printGameRestartMessage()
            return if (gameRestart()) GameStatus.GAME_START else GameStatus.GAME_OVER
        }
        return gameStatus
    }

    private fun gameRestart(): Boolean {
        return when (inputView.getInputBaseballRestart()) {
            "1" -> true
            else -> {
                outputView.printGameOverMessage()
                false
            }
        }
    }
}