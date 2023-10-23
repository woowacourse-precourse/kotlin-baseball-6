package baseball.util

import baseball.util.Constants.EXCEPTION_WRONG_FORMAT
import baseball.util.Constants.EXCEPTION_WRONG_LENGTH
import baseball.util.Constants.EXCEPTION_WRONG_RANGE
import baseball.util.Constants.LENGTH_NUMBER
import baseball.util.Constants.MAX_DIGIT
import baseball.util.Constants.MIN_DIGIT

object Validation {

    fun validateDigit(digit: Char) : Int {
        val num = digit.digitToIntOrNull() ?: throw IllegalArgumentException(EXCEPTION_WRONG_FORMAT)
        validateRange(num)
        return num
    }

    fun validateRange(num: Int) {
        if (num !in MIN_DIGIT..MAX_DIGIT) {
            throw IllegalArgumentException(EXCEPTION_WRONG_RANGE)
        }
    }

    fun validateLength(number: MutableList<Int>) {
        if (number.size != LENGTH_NUMBER) {
            throw IllegalArgumentException(EXCEPTION_WRONG_LENGTH)
        }
    }
}