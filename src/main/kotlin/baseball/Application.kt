package baseball

import baseball.controller.GameController
import baseball.model.RandomAnswerGenerator
import baseball.model.Referee

fun main() {
    val gameController = GameController(
        referee = Referee(),
        answerGenerator = RandomAnswerGenerator()
    )
    gameController.start()
}
