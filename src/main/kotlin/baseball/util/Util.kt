package baseball.util

import baseball.BaseBallGame
import baseball.constants.*

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

fun validateInputExit(inputExitGame: String) {
    if (inputExitGame != "1" && inputExitGame != "2") {
        throw IllegalArgumentException(EXCEPTION_EXIT)
    }
}