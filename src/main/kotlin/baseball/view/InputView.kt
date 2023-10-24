package baseball.view

import baseball.controller.GameManager
import camp.nextstep.edu.missionutils.Console
import baseball.model.UserNumCompare


class InputView {
    fun UserNumInput(): String? {
        val input = Console.readLine()

        return input
    }
}