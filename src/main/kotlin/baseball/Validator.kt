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

    fun isInvalidNumericInput(input: String): Boolean {
        return !input.all { it.isDigit() } or input.isBlank()
    }
}