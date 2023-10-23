package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class User {
    companion object {
        private const val RESTART = "1"
        private const val QUIT = "2"
        private const val SIZE = 3
        private const val NOT_VALIDATE_LENGTH = "3자리의 입력이 아닙니다."
        private const val NOT_VALIDATE_NUMBER = "사용자의 입력이 1부터 9까지의 숫자가 아닙니다."
        private const val NOT_UNIQUE_NUMBER = "사용자의 입력 중 중복된 숫자가 존재합니다."
        private const val NOT_VALIDATE_RESTART_NUMBER = "입력이 1 또는 2가 아닙니다."
    }

    fun inputUserNumber(): MutableList<Int> {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()
        checkValidUserNumber(userNumber)

        return userNumber.map { it.digitToInt() }.toMutableList()
    }

    fun decideGame(): Boolean {
        val userInput = Console.readLine()
        checkValidRestartNumber(userInput)

        return userInput == RESTART
    }

    private fun checkValidUserNumber(number: String) {
        validateLength(number)
        validateNumber(number)
        validateUnique(number)
    }

    private fun validateLength(number: String) {
        if (number.length != SIZE) {
            throw IllegalArgumentException(NOT_VALIDATE_LENGTH)
        }
    }

    private fun validateNumber(number: String) {
        val regex = Regex("[1-9]{3}")

        if (!regex.matches(number)) {
            throw IllegalArgumentException(NOT_VALIDATE_NUMBER)
        }
    }

    private fun validateUnique(number: String) {
        if (number.toList().distinct().size != SIZE) {
            throw IllegalArgumentException(NOT_UNIQUE_NUMBER)
        }
    }

    private fun checkValidRestartNumber(input: String) {
        if (input == RESTART || input == QUIT) {
            return
        }

        throw IllegalArgumentException(NOT_VALIDATE_RESTART_NUMBER)
    }
}