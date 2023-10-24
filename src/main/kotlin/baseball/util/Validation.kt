package baseball.util

import baseball.util.Constants.EXCEPTION_DUPLICATE_NUMBER
import baseball.util.Constants.EXCEPTION_WRONG_FORMAT
import baseball.util.Constants.EXCEPTION_WRONG_LENGTH
import baseball.util.Constants.EXCEPTION_WRONG_RANGE
import baseball.util.Constants.EXCEPTION_WRONG_VALUE
import baseball.util.Constants.LENGTH_NUMBER
import baseball.util.Constants.MAX_DIGIT
import baseball.util.Constants.MIN_DIGIT
import baseball.util.Constants.RESTART
import baseball.util.Constants.END

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

    fun validateDuplicate(number: MutableList<Int>) {
        if (number.toSet().size != LENGTH_NUMBER) {
            throw IllegalArgumentException(EXCEPTION_DUPLICATE_NUMBER)
        }
    }

    fun validateRestartFlag(flag: String) {
        if (flag != RESTART && flag != END) {
            throw IllegalArgumentException(EXCEPTION_WRONG_VALUE)
        }
    }
}