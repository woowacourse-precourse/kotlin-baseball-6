package baseball.view

import baseball.utils.Constants
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getUserInputNum(): Int {
        print(Constants.INPUT_USER_MESSAGE)
        val input = Console.readLine()

        if (input.length != 3 || !input.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }
}