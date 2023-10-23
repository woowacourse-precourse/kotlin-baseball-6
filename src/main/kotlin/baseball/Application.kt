package baseball

import baseball.controller.BaseBallGameController
import baseball.domain.CompareNumbers
import baseball.domain.ValidateUserInput
import baseball.view.PrintResultView
import baseball.view.ReadNumberView
import baseball.view.ReadUserRestartChoiceView

fun main() {
    BaseBallGameController(
        ReadNumberView(),
        ReadUserRestartChoiceView(),
        PrintResultView(),
        CompareNumbers(),
        ValidateUserInput()
    ).play()
}




