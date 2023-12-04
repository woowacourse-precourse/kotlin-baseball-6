package baseball.application

import baseball.controller.BaseBallGame
import baseball.presentation.InputView
import baseball.presentation.OutputView

fun main() {
    val baseBallGame = BaseBallGame(
        inputView = InputView(),
        outputView = OutputView(),
    )
    baseBallGame.play()
}