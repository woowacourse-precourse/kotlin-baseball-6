package baseball

import baseball.controller.Controller
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val controller = Controller(inputView, outputView)

    controller.process()
}
