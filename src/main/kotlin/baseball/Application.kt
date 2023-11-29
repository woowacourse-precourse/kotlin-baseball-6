package baseball

import baseball.controller.BaseBallGame
import baseball.presentation.InputView
import baseball.presentation.OutputView

fun main() {
    val baseBallGame = BaseBallGame(
        InputView(),
        OutputView()
    )
    baseBallGame.play()
}