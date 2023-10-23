package baseball.domain.player

data class PlayerNumber(val numbers: Int) {

    init {
        require(this.numbers in DIGIT_RANGE) { "INVALID_DIGIT_ERROR_MESSAGE" }
    }

    companion object {
        private const val INVALID_DIGIT_ERROR_MESSAGE = "입력된 각 자리의 숫자는 1부터 9까지 여야 합니다."
        private val DIGIT_RANGE = 1..9
    }
}
