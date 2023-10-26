package baseball

import baseball.controller.GameController
import baseball.controller.OutputManager
import baseball.domain.AnswerCreator
import baseball.domain.Computer
import baseball.util.RandomNumberPicker
import baseball.view.InputValidator
import baseball.view.InputView
import io.Printer

fun main() {
    val inputValidator = InputValidator()
    val inputView = InputView(inputValidator)
    val outputManager = OutputManager(Printer())
    val randomNumberPicker = RandomNumberPicker()
    val answerCreator = AnswerCreator(randomNumberPicker)
    val computer = Computer(answerCreator)
    val gameController = GameController(inputView, outputManager, computer)

    gameController.run()
}
