package baseball.controller

import baseball.model.Answer
import baseball.model.ExitInput
import baseball.model.GameResult
import baseball.util.RandomNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class GameController {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.printGameStart()
        while (true) {
            val computerAnswer = Answer(RandomNumberGenerator.generate(1, 9, 3))
            startUserGuessing(computerAnswer)

            if (ExitInput(inputView.getExitInput()).isExit()) {
                inputView.terminated()
                return
            }
        }
    }

    private fun startUserGuessing(computerAnswer: Answer) {
        while (true) {
            val userAnswer = Answer(inputView.getUserAnswer())
            val result = GameResult(computerAnswer, userAnswer)
            outputView.printResult(result)

            if (result.isAllStrike()) {
                outputView.printGameClear()
                return
            }
        }
    }
}