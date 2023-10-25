package baseball.view

import baseball.domain.UserExpect
import baseball.util.NumberValidator
import camp.nextstep.edu.missionutils.Console


class ReadUserInputView {

    private val validator = NumberValidator()
    fun readUserNumberInput(): UserExpect {
        val userInput = Console.readLine()
        validateUserInput(userInput)
        return UserExpect(userInput)
    }

    fun readUserRestartInput(): Int {
        val userRestart = Console.readLine()
        validateUserInput(userRestart)
        return userRestart.toInt()
    }

    private fun validateUserInput(userInput: String) {
        validator.isNumberFormat(userInput)
    }
}