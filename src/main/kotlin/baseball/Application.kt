package baseball

import baseball.controller.GameController
import baseball.domain.AnswerCreator
import baseball.domain.Computer
import baseball.util.RandomNumberPicker
import baseball.view.InputValidator
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val inputValidator = InputValidator()
    val inputView = InputView(inputValidator)
    val outputView = OutputView()
    val randomNumberPicker = RandomNumberPicker()
    val answerCreator = AnswerCreator(randomNumberPicker)
    val computer = Computer(answerCreator)
    val gameController = GameController(inputView, outputView, computer)

    gameController.run()
}
