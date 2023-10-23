package baseball

class ThrowIAE {

    fun checkNullOrBlank(string: String?) {
        if (string.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
    }

    fun checkLength(string: String, length: Int) {
        if (string.length != length) {
            throw IllegalArgumentException()
        }
    }

    fun checkToInt(string: String): Int {
        try {
            return string.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    fun checkNumZero(number: Int) {
        if (number == 0) {
            throw IllegalArgumentException()
        }
    }

    fun checkElemDuplication(mutableList: MutableList<Int>, number: Int) {
        if (mutableList.contains(number)) {
            throw IllegalArgumentException()
        }
    }
}