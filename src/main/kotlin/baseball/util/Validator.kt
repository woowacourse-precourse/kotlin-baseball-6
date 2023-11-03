package baseball.util

import baseball.util.Constants.GAME_NUMBER_LENGTH
import baseball.util.Constants.QUIT
import baseball.util.Constants.REGEX
import baseball.util.Constants.RESTART
import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(number: String) {
        if (number.length != GAME_NUMBER_LENGTH) throw IllegalArgumentException(Exception.INVALID_NUMBER_LENGTH.getMessage())
    }

    fun validateInteger(number: String) {
        number.toIntOrNull() ?: throw IllegalArgumentException(Exception.INVALID_INTEGER.getMessage())
    }

    fun validateRange(number: String) {
        val regex = REGEX.toRegex()
        if (!regex.matches(number)) throw IllegalArgumentException(Exception.INVALID_RANGE.getMessage())
    }

    fun validateUniqueNumber(number: String) {
        val validation = number.toSet()
        if (validation.size != GAME_NUMBER_LENGTH) throw IllegalArgumentException(Exception.INVALID_UNIQUE.getMessage())
    }

    fun validateGameStatus(number: String) {
        if (number == RESTART || number == QUIT) {
            return
        }

        throw IllegalArgumentException(Exception.INVALID_GAME_STATUS_NUMBER.getMessage())
    }
}