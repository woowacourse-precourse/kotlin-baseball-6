package baseball.util

import baseball.BaseBallGame

fun validate(inputBaseBallNumber: List<Int>) {
    validateInputBaseBallSize(inputBaseBallNumber)
    validateInputBaseBallDuplication(inputBaseBallNumber)
    validateInputBaseBallRange(inputBaseBallNumber)
}

private fun validateInputBaseBallSize(inputBaseBallNumber: List<Int>) {
    if (inputBaseBallNumber.size != BaseBallGame.BASEBALL_SIZE) {
        throw IllegalArgumentException("3개의 숫자를 입력해주세요.")
    }
}

private fun validateInputBaseBallDuplication(inputBaseBallNumber: List<Int>) {
    val distinctBaseBallNumber = inputBaseBallNumber.distinct()
    if (distinctBaseBallNumber.size != BaseBallGame.BASEBALL_SIZE) {
        throw IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.")
    }
}

private fun validateInputBaseBallRange(inputBaseBallNumber: List<Int>) {
    val rangeBaseBallNumber = inputBaseBallNumber.filter { it in 1..8 }
    if (rangeBaseBallNumber.size != BaseBallGame.BASEBALL_SIZE) {
        throw IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.")
    }
}