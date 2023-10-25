package baseball

import java.lang.IllegalArgumentException

class Validator {

    fun validateNumbers(input: String, numberCount: Int, minNumber: Int, maxNumber: Int) {
        checkNumberCount(input, numberCount)
        checkNumberFormat(input)
        checkNumberRange(input, minNumber, maxNumber)
        checkNumberDistinction(input)
    }

    private fun checkNumberCount(input: String, numberCount: Int) {
        if (input.length != numberCount)
            throw IllegalArgumentException()
    }

    private fun checkNumberFormat(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false))
            throw IllegalArgumentException()
    }

    private fun checkNumberRange(input: String, minNumber: Int, maxNumber: Int) {
        if (input.map { data -> Character.getNumericValue(data) in minNumber..maxNumber }.contains(false))
            throw IllegalArgumentException()
    }

    private fun checkNumberDistinction(input: String) {
        if (input.length != input.toSet().size)
            throw IllegalArgumentException()
    }

    fun validateCommand(input: String) {
        checkNumberCount(input, 1)
        checkNumberFormat(input)
        checkNumberRange(input, 1, 2)
    }
}