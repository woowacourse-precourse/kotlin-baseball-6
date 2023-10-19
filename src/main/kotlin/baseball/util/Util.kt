package baseball.util

import baseball.BaseBallGame
import baseball.constants.BASEBALL_SIZE
import baseball.constants.EXCEPTION_DUPLICATION
import baseball.constants.EXCEPTION_RANGE
import baseball.constants.EXCEPTION_SIZE

fun validateInputBaseBall(inputBaseBallNumber: List<Int>) {
    validateInputBaseBallSize(inputBaseBallNumber)
    validateInputBaseBallDuplication(inputBaseBallNumber)
    validateInputBaseBallRange(inputBaseBallNumber)
}

private fun validateInputBaseBallSize(inputBaseBallNumber: List<Int>) {
    if (inputBaseBallNumber.size != BASEBALL_SIZE) {
        throw IllegalArgumentException(EXCEPTION_SIZE)
    }
}

private fun validateInputBaseBallDuplication(inputBaseBallNumber: List<Int>) {
    val distinctBaseBallNumber = inputBaseBallNumber.distinct()
    if (distinctBaseBallNumber.size != BASEBALL_SIZE) {
        throw IllegalArgumentException(EXCEPTION_DUPLICATION)
    }
}

private fun validateInputBaseBallRange(inputBaseBallNumber: List<Int>) {
    val rangeBaseBallNumber = inputBaseBallNumber.filter { it in 1..8 }
    if (rangeBaseBallNumber.size != BASEBALL_SIZE) {
        throw IllegalArgumentException(EXCEPTION_RANGE)
    }
}