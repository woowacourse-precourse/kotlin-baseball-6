package baseball.util

import baseball.util.Constants.EXCEPTION_WRONG_FORMAT

object Validation {

    fun validateDigit(digit: Char) : Int {
        val num = digit.digitToIntOrNull() ?: throw IllegalArgumentException(EXCEPTION_WRONG_FORMAT)
        return num
    }
}