package baseball.Util

import baseball.Util.Constants.GAME_NUMBER_LENGTH
import baseball.Util.Constants.QUIT
import baseball.Util.Constants.REGEX
import baseball.Util.Constants.RESTART
import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(number: String) {
        if (number.length != GAME_NUMBER_LENGTH) throw IllegalArgumentException("사용자의 입력이 3자리가 아닙니다.")
    }

    fun validateInteger(number: String) {
        number.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 정수가 아닙니다.")
    }

    fun validateRange(number: String) {
        val regex = REGEX.toRegex()
        if (!regex.matches(number)) throw IllegalArgumentException("사용자의 입력이 1부터 9까지의 숫자가 아닙니다.")
    }

    fun validateUniqueNumber(number: String) {
        val validation = number.toSet()
        if (validation.size != GAME_NUMBER_LENGTH) throw IllegalArgumentException("사용자의 입력 중 중복된 숫자가 존재합니다.")
    }

    fun validateGameStatus(number: String) {
        if (number == RESTART || number == QUIT) {
            return
        }

        throw IllegalArgumentException("사용자의 입력이 1 또는 2가 아닙니다.")
    }
}