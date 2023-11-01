package baseball

import baseball.controller.GameController
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val gameController = GameController(inputView, outputView)
    gameController.run()
}