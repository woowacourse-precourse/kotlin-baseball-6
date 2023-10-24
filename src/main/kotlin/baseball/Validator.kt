package baseball

import net.bytebuddy.implementation.bytecode.collection.ArrayLength

class Validator {
    fun validateString(inputString: String) {
        isNumber(inputString)
        isValidLength(inputString, 3)
    }

    fun toNumberList(inputString: String): MutableList<Int> {
        val numberList = mutableListOf<Int>()
        for (char in inputString) {
            numberList.add(char.code - '0'.code)
        }
        validateNumbers(numberList)
        return numberList
    }

    fun validateRestartNumber(inputString: String): Int {
        isValidLength(inputString, 1)
        isNumber(inputString)
        val num: Int = inputString.toInt()
        return if (num == 1 || num == 2) {
            num
        } else {
            throw IllegalArgumentException("input must be 1 or 2")
        }
    }

    private fun validateNumbers(inputList: List<Int>) {
        hasDuplicates(inputList)
        hasZero(inputList)
    }

    private fun isValidLength(inputString: String, length: Int) {
        if (inputString.length != length) {
            throw IllegalArgumentException("input's length must be ${length}, but ${inputString.length}")
        }
    }

    private fun isNumber(inputString: String) {
        if (inputString.toIntOrNull() == null) {
            throw IllegalArgumentException("input string must be integer")
        }
    }

    private fun hasDuplicates(inputList: List<Int>) {
        if (inputList.size != inputList.distinct().size) {
            throw IllegalArgumentException("there is duplicated number")
        }
    }

    private fun hasZero(inputList: List<Int>) {
        if (inputList.contains(0)) {
            throw IllegalArgumentException("input numbers must not have 0(zero)")
        }
    }
}