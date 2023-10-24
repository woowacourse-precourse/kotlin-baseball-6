package baseball.view

import baseball.controller.GameManager
import baseball.model.RandomGenerator
import baseball.model.UserNumCompare
import java.io.Console

class InputView {
    init {
        UserNumInput()
    }
    private fun UserNumInput() {

        val input = readLine()

        UserNumCompare(input,GameManager().answer)
    }
}