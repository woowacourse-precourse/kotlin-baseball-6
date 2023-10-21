package baseball.exception

const val CORRECT_SIZE = 3
const val ZERO = '0'

class ExceptionChecker {
    private val exception = IllegalArgumentException()

    fun checkValidation(num: String) {
        checkSize(num)
        checkZero(num)
        checkDuplicateNumber(num)
    }

    private fun checkSize(num: String) {
        if (num.length != CORRECT_SIZE) {
            throw exception
        }
    }

    private fun checkZero(num: String) {
        if (num.contains(ZERO)) {
            throw exception
        }
    }

    private fun checkDuplicateNumber(num: String) {
        var numList = num.toList().distinct()

        if (num.length != numList.size) {
            throw exception
        }

    }

    fun checkRetryInput(choice: Int) {
        if(choice != 1 && choice != 2) {
            throw exception
        }
    }
}