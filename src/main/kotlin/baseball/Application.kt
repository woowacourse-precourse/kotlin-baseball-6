package baseball

import baseball.controller.BaseBallGameController
import baseball.view.PrintOutputView
import baseball.view.ReadUserInputView

fun main() {
    BaseBallGameController(
        ReadUserInputView(),
        PrintOutputView()
    ).play()
}




