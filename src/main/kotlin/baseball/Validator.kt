package baseball

import java.lang.IllegalArgumentException

class Validator(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {

    fun validateNumbers(input: String) {
        checkNumberCount(input)
        checkNumberFormat(input)
        checkNumberRange(input)
        checkNumberDistinction(input)
    }

    private fun checkNumberCount(input: String) {
        if (input.length != numberCount)
            throw IllegalArgumentException()
    }

    private fun checkNumberFormat(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false))
            throw IllegalArgumentException()
    }

    private fun checkNumberRange(input: String) {
        if (input.map { data -> Character.getNumericValue(data) in minNumber..maxNumber }.contains(false))
            throw IllegalArgumentException()
    }

    private fun checkNumberDistinction(input: String) {
        if (input.length != input.toSet().size)
            throw IllegalArgumentException()
    }
}