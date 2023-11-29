package baseball.model

data class BaseballNumber(val number: Int) {
    init {
        require(number in START_NUMBER..END_NUMBER) {
            INVALID_NUMBER_RANGE
        }
    }

    companion object {
        const val START_NUMBER = 1
        const val END_NUMBER = 9
        const val INVALID_NUMBER_RANGE = "숫자는 $START_NUMBER 와 $END_NUMBER 사이의 수여야 합니다."
    }
}
