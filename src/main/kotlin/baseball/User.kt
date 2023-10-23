package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class User {
    fun inputUserNumber(): MutableList<Int> {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()
        checkValidUserNumber(userNumber)

        return userNumber.map { it.digitToInt() }.toMutableList()
    }

    fun decideGame(): Boolean {
        val userInput = Console.readLine()
        checkValidRestartNumber(userInput)

        if (userInput == "1") {
            return true
        }

        return false
    }

    private fun checkValidUserNumber(number: String) {
        validateLength(number)
        validateNumber(number)
        validateUnique(number)
    }

    private fun validateLength(number: String) {
        if (number.length != 3) {
            throw IllegalArgumentException("3자리의 입력이 아닙니다.")
        }
    }

    private fun validateNumber(number: String) {
        for (i in 0..<number.length) {
            val asciiCode = number[i].code

            if (asciiCode !in 48..57) {
                throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
            }
        }

        number.forEach { num ->
            val iNum = num.digitToInt()

            if (iNum !in 1..9) {
                throw IllegalArgumentException("사용자의 입력이 1부터 9까지의 숫자가 아닙니다.")
            }
        }
    }

    private fun validateUnique(number: String) {
        if (number.toList().distinct().size != 3) {
            throw IllegalArgumentException("사용자의 입력 중 중복된 숫자가 존재합니다.")
        }
    }

    private fun checkValidRestartNumber(input: String) {
        if (input == "1" || input == "2") {
            return
        }

        throw IllegalArgumentException("입력이 1 또는 2가 아닙니다.")
    }
}