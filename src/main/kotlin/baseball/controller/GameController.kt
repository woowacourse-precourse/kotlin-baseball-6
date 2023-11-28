package baseball.controller

import baseball.model.BaseballNumbers
import baseball.model.RandomAnswer
import baseball.model.Referee
import baseball.view.Command
import baseball.view.InputView
import baseball.view.OutputView

class GameController {

    private val inputView = InputView()
    private val outputView = OutputView()

    private val numbersConverter = NumbersConverter()
    private val referee = Referee()


    fun start() {
        outputView.showStartPrompt()
        do {
            val answer = RandomAnswer().generated()
            println(answer)
            startGame(answer)
            outputView.showSuccessPrompt()
        } while (inputView.readCommand() == Command.RESTART)
    }

    private fun startGame(answer: BaseballNumbers) {
        do {
            val userBaseballNumbers = numbersConverter.toBaseballNumbers(inputView.readNumbers())
            val ballAndStrike = referee.compare(userBaseballNumbers, answer)
            outputView.showTurnResult(ballAndStrike)
        } while (!ballAndStrike.isSuccess())
    }
}