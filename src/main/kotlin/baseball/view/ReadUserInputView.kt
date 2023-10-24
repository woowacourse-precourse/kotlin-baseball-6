package baseball.view

import baseball.constant.ErrorMessage
import camp.nextstep.edu.missionutils.Console


class ReadUserInputView {
    fun readUserNumberInput(): String {
        val userNumber = Console.readLine()
        validateNumber(userNumber)
        return userNumber
    }

    fun readUserRestartInput(): String {
        val userRestart = Console.readLine()
        validateRestart(userRestart)
        return userRestart
    }

    private fun validateNumber(userInput: String) {
        require(isNumberFormat(userInput)) { ErrorMessage.NOT_NUMBER.message }
        val userNumber = userInput.toInt()
        require(isCorrectRangeNumber(userNumber)) { ErrorMessage.NOT_NUMBER_RANGE.message }
    }

    private fun validateRestart(userInput: String) {
        require(isNumberFormat(userInput)) { ErrorMessage.NOT_NUMBER.message }
        val userChoice = userInput.toInt()
        require(isCorrectRangeChoice(userChoice)) { ErrorMessage.NOT_RESTART_RANGE.message }
    }

    private fun isNumberFormat(userChoice: String): Boolean {
        return userChoice.all { char -> char.isDigit() }
    }

    private fun isCorrectRangeChoice(userNumber: Int): Boolean {
        return when (userNumber) {
            in RESTART_GAME..EXIT_GAME -> true

            else -> false
        }
    }

    private fun isCorrectRangeNumber(userNumber: Int): Boolean {
        return when (userNumber) {
            in MIN_VALUE..MAX_VALUE -> true
            else -> false
        }
    }

    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
        private const val MIN_VALUE = 100
        private const val MAX_VALUE = 999
    }
}