package baseball.app

import baseball.controller.BaseballGameController
import baseball.model.BaseballGameModel
import baseball.view.BaseballGameView

class BaseballGameApp {
    private val view = BaseballGameView()
    private val model = BaseballGameModel()
    private val controller = BaseballGameController(view = view, model = model)

    fun run() {
        controller.run()
    }
}