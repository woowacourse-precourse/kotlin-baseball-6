package baseball.service

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
            throw IllegalArgumentException("입력한 수가 ${DIGIT_NUMBER}자리가 아닙니다.")
        }
    }

    private fun validateFormat(input: String) {
        if (input.contains("""[^$START_INCLUSIVE -$END_INCLUSIVE]""".toRegex())) {
            throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }
    }

    private fun validateDuplication(input: String) {
        if (input.toCharArray().toSet().size < DIGIT_NUMBER) {
            throw IllegalArgumentException("입력이 중복된 수를 가집니다.")
        }
    }
}