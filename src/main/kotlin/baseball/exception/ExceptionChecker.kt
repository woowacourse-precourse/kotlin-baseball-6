package baseball.exception

const val CORRECT_SIZE = 3
const val ZERO = '0'

class ExceptionChecker {
    private val exception = IllegalArgumentException()

    fun checkValidation(num: String) {
        checkSize(num)
        checkIsNum(num)
        checkDuplicateNumber(num)
    }

    private fun checkSize(num: String) {
        if (num.length != CORRECT_SIZE) {
            throw exception
        }
    }

    private fun checkIsNum(num: String) {
        val numRange = listOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (i in 0 until CORRECT_SIZE) {
            if (!numRange.contains(num[i])) {
                throw exception
            }
        }
    }


    private fun checkDuplicateNumber(num: String) {
        var numList = num.toList().distinct()

        if (num.length != numList.size) {
            throw exception
        }

    }

    fun checkRetryInput(choice: String) {
        if (choice != "1" && choice != "2") {
            throw exception
        }
    }
}