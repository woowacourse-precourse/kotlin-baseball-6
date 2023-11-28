package baseball

import baseball.controller.GameController
import baseball.model.RandomAnswer
import baseball.model.Referee

fun main() {
    val gameController = GameController(
        referee = Referee(),
        answer = RandomAnswer()
    )
    gameController.start()
}
