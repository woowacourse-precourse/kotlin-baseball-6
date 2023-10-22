package baseball

import baseball.controllr.BaseballController
import baseball.model.BaseballModel
import baseball.view.BaseballView

fun main() {
    val model = BaseballModel()
    val view = BaseballView()
    val controller = BaseballController(model, view)

    controller.startGame()
}