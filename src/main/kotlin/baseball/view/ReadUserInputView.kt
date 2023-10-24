package baseball.view

import baseball.domain.ChoiceState
import camp.nextstep.edu.missionutils.Console


class ReadUserInputView {

    fun readUserNumberInput(): String {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()
        validateNumber(userNumber)
        return userNumber
    }

    fun readUserRestartInput(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userRestart = Console.readLine()
        validateRestart(userRestart)
        return userRestart
    }

    fun validateNumber(userInput: String): Int {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다!" }
        val userNumber = userInput.toInt()
        require(isCorrectRangeNumber(userNumber)) { "세자리 숫자여야 합니다!" }
        return userNumber

    }

    fun validateRestart(userInput: String): ChoiceState {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다!" }
        val userChoice = userInput.toInt()
        require(isCorrectRangeChoice(userChoice)) { "1 또는 2를 입력해주세요!" }
        return when (userChoice) {
            RESTART_GAME -> ChoiceState.RESTART
            EXIT_GAME -> ChoiceState.EXIT
            else -> {
                require(true) { "1 또는 2를 입력해주세요!" }
                ChoiceState.EXIT
            }
        }
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
        const val RESTART_GAME = 1
        const val EXIT_GAME = 2
        const val MIN_VALUE = 100
        const val MAX_VALUE = 999
    }
}