package baseball.domain


class BallNumbers(private val numbers: List<BallNumber>) {

    init {
        validateNumbersLength(numbers)
    }

    fun isStrikeAt(index: Int, other: BallNumbers) =
            numbers[index] == other.numbers[index]

    fun isBallAt(index: Int, other: BallNumbers) =
            !isStrikeAt(index, other) &&
                    numbers.any { it == other.numbers[index] }

    companion object {

        private const val BALL_COUNT = 3

        private fun validateNumbersLength(numbers: List<BallNumber>) {
            if (numbers.size != BALL_COUNT) {
                throw IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.")
            }
        }
    }

}
