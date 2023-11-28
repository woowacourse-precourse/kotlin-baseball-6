package baseball.controller

import baseball.model.AnswerGenerator
import baseball.model.BaseballNumbers
import baseball.model.Referee
import baseball.view.Command
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    val referee: Referee,
    val answerGenerator: AnswerGenerator
) {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.showStartPrompt()
        do {
            val thisAnswer = answerGenerator.generate()
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