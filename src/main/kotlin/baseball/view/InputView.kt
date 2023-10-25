package baseball.view

import baseball.domain.InputValidator
import baseball.utils.Constants
import camp.nextstep.edu.missionutils.Console

class InputView(private val inputValidator: InputValidator) {

    fun getUserInputNum(): Int {
        print(Constants.INPUT_USER_MESSAGE)
        val input = Console.readLine()

        return inputValidator.validate(input)
    }
}