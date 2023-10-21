package baseball

const val START_NUMBER = 1
const val END_NUMBER = 9
const val NUMBER_COUNT = 3

object Validator {
    fun areInvalidCountNumbers(numbers: List<Int>): Boolean {
        return numbers.size != NUMBER_COUNT
    }

    fun areOutOfRangeNumbers(numbers: List<Int>): Boolean {
        return numbers.any { it < START_NUMBER || it > END_NUMBER }
    }

    fun areDuplicateNumbers(numbers: List<Int>): Boolean {
        val distinctNumbers = numbers.toSet()
        return numbers.size != distinctNumbers.size
    }

    fun validateNumbers(numbers: List<Int>) {
        if (areInvalidCountNumbers(numbers)) {
            throw IllegalArgumentException("수의 개수가 올바르지 않습니다.")
        }

        if (areOutOfRangeNumbers(numbers)) {
            throw IllegalArgumentException("수의 범위가 잘못되었습니다.")
        }

        if (areDuplicateNumbers(numbers)) {
            throw IllegalArgumentException("중복된 수가 있습니다.")
        }
    }

    fun isInvalidNumericInput(input: String): Boolean {
        return !input.all { it.isDigit() }
    }

    fun isBlankInput(input: String): Boolean {
        return input.isBlank()
    }

    fun validateInput(input: String) {
        if (Validator.isInvalidNumericInput(input)) {
            throw IllegalArgumentException("숫자로만 입력해주세요.")
        }

        if (Validator.isBlankInput(input)) {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }
    }
}