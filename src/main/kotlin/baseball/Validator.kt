package baseball

import java.lang.IllegalArgumentException

class Validator {

    fun checkNumberCount(input: String, count: Int) {
        if (input.length != count)
            throw IllegalArgumentException()
    }

    fun checkNumberFormat(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false))
            throw IllegalArgumentException()
    }

    fun checkNumberRange(input: String, min: Int, max: Int) {
        if (input.map { data -> Character.getNumericValue(data) in min..max }.contains(false))
            throw IllegalArgumentException()
    }

    fun checkNumberDistinction(input: String) {
        if (input.length != input.toSet().size)
            throw IllegalArgumentException()
    }
}