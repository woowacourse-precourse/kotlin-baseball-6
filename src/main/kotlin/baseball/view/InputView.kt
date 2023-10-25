package baseball.view

import camp.nextstep.edu.missionutils.Console


class InputView {
    fun UserNumInput(): String? {
        val input = Console.readLine()

        return input
    }
}