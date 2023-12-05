package baseball.model

private const val MAX_NUMBER = 3

private const val MIN_NUMBER = 0

data class Score(
        val strikes: Int,
        val balls: Int
) {

    init {
        validateCount(strikes, balls)
        validateRange(strikes, balls)
    }

    fun isEnd(): Boolean {
        return strikes == MAX_NUMBER && balls == MIN_NUMBER
    }

    fun isNothing(): Boolean {
        return strikes == MIN_NUMBER && balls == MIN_NUMBER
    }

    private fun validateCount(strike: Int, ball: Int) {
        require(strike + ball in MIN_NUMBER..MAX_NUMBER) {
            "스트라이크와 볼의 합계는 ${MIN_NUMBER}와 $MAX_NUMBER 사이에 위치해야합니다."
        }
    }

    private fun validateRange(strike: Int, ball: Int) {
        require(strike >= MIN_NUMBER && ball >= MIN_NUMBER) {
            "스트라이크와 볼은 ${MIN_NUMBER}보다 커야 합니다."
        }
    }
}
