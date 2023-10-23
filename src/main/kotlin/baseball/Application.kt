package baseball

import baseball.controllr.GameController
import baseball.model.GameRulesManager
import baseball.view.GameView

fun main() {
    val model = GameRulesManager()
    val view = GameView()
    val controller = GameController(model, view)

    controller.startGame()
}