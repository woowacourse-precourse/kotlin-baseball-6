package baseball

import baseball.Controller.GameController
import baseball.View.InputView
import baseball.View.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val gameController = GameController(inputView, outputView)
    gameController.run()
}