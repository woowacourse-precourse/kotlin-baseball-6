package baseball.Util

import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(number: String) {
        if (number.length != 3) throw IllegalArgumentException("사용자의 입력이 3자리가 아닙니다.")
    }

    fun validateInteger(number: String) {
        number.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 정수가 아닙니다.")
    }

    fun validateRange(number: String) {
        val regex = Regex("[1-9]{3}")
        if (!regex.matches(number)) throw IllegalArgumentException("사용자의 입력이 1부터 9까지의 숫자가 아닙니다.")
    }

    fun validateUniqueNumber(number: String) {
        val validation = number.toSet()
        if (validation.size != 3) throw IllegalArgumentException("사용자의 입력 중 중복된 숫자가 존재합니다.")
    }

    fun validateGameStatus(number: String) {
        if (number == "1" || number == "2") {
            return
        }

        throw IllegalArgumentException("사용자의 입력이 1 또는 2가 아닙니다.")
    }
}