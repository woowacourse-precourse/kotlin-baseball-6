package baseball

class Validator {
    fun validateString(inputString: String) {
        isNumber(inputString)
        isLengthThree(inputString)
    }

    fun toNumberList(inputString: String) : MutableList<Int>{
        val numberList = mutableListOf<Int>()
        for (char in inputString) {
            numberList.add(char.code - '0'.code)
        }
        validateNumbers(numberList)
        return numberList
    }

    private fun validateNumbers(inputList: List<Int>) {
        hasDuplicates(inputList)
        hasZero(inputList)
    }

    private fun isLengthThree(inputString: String) {
        if (inputString.length != 3) {
            throw IllegalArgumentException("input's length must be 3, but ${inputString.length}")
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