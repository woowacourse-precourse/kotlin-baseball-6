package baseball

import baseball.controller.GameController
import baseball.domain.AnswerCreator
import baseball.view.InputValidator
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val inputValidator = InputValidator()
    val inputView = InputView(inputValidator)
    val outputView = OutputView()
    val answerCreator = AnswerCreator()
    val gameController = GameController(inputView, outputView, answerCreator)

    gameController.run()
}
