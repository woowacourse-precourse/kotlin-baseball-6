package baseball.controller

import baseball.model.Answer
import baseball.model.BaseballNumbers
import baseball.model.Referee
import baseball.view.Command
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    val referee: Referee,
    val answer: Answer
) {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.showStartPrompt()
        do {
            val thisAnswer = answer.generated()
            startGame(thisAnswer)
            outputView.showSuccessPrompt()
        } while (inputView.readCommand() == Command.RESTART)
    }

    private fun startGame(answer: BaseballNumbers) {
        do {
            val userBaseballNumbers = (inputView.readNumbers()).toBaseballNumbers()
            val ballAndStrike = referee.compare(userBaseballNumbers, answer)
            outputView.showTurnResult(ballAndStrike)
        } while (!ballAndStrike.isSuccess())
    }
}