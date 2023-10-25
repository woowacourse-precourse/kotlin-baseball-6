package baseball.service

import baseball.config.ExceptionMsg.DUPLICATE_INPUT
import baseball.config.ExceptionMsg.INVALID_FORMAT
import baseball.config.ExceptionMsg.WRONG_DIGIT_COUNT
import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.config.GameNumberConfig.END_INCLUSIVE
import baseball.config.GameNumberConfig.START_INCLUSIVE

class NumberValidator {

    fun validate(input: String) {
        validateLength(input)
        validateFormat(input)
        validateDuplication(input)
    }

    private fun validateLength(input: String) {
        if (input.length != DIGIT_NUMBER) {
            throw IllegalArgumentException(WRONG_DIGIT_COUNT)
        }
    }

    private fun validateFormat(input: String) {
        if (input.contains("""[^$START_INCLUSIVE -$END_INCLUSIVE]""".toRegex())) {
            throw IllegalArgumentException(INVALID_FORMAT)
        }
    }

    private fun validateDuplication(input: String) {
        if (input.toCharArray().toSet().size < DIGIT_NUMBER) {
            throw IllegalArgumentException(DUPLICATE_INPUT)
        }
    }
}