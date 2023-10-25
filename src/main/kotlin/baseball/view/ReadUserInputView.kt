package baseball.view

import baseball.constant.ErrorMessage
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
        require(validator.isNumberFormat(userInput)) { ErrorMessage.NOT_NUMBER.message }
    }


    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
        private const val MIN_VALUE = 100
        private const val MAX_VALUE = 999
    }
}