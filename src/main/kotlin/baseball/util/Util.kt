package baseball.util

import baseball.constants.*
import camp.nextstep.edu.missionutils.Randoms

fun pickBaseBallNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < BASEBALL_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }

    return computerNumber
}

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
    val rangeBaseBallNumber = inputBaseBallNumber.filter { it in 1..9 }
    if (rangeBaseBallNumber.size != BASEBALL_SIZE) {
        throw IllegalArgumentException(EXCEPTION_RANGE)
    }
}

fun validateInputExit(inputExitGame: String) {
    if (inputExitGame != "1" && inputExitGame != "2") {
        throw IllegalArgumentException(EXCEPTION_EXIT)
    }
}

fun String.toDigitList() = this.map {
    it.code - '0'.code
}