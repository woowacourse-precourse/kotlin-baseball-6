package baseball.model

data class BaseballNumbers(val numbers: List<BaseballNumber>) {

    init {
        require(numbers.size == 3) {
            INVALID_NUMBERS_SIZE
        }
        require(numbers.distinct().size == 3) {
            NUMBERS_DUPLICATED
        }
    }

    companion object {
        const val NUMBERS_DIGIT = 3
        const val INVALID_NUMBERS_SIZE = "숫자는 $NUMBERS_DIGIT 자리 수가 되어야 합니다."
        const val NUMBERS_DUPLICATED = "숫자에 중복된 수가 있습니다."
    }
}