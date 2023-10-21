package baseball.domain

class BallNumbers(private val numbers: List<Int>) {

    init {
        validateNumbersLength(numbers)
        validateNumbers(numbers)
    }

    fun isStrikeAt(index: Int, other: BallNumbers) =
            numbers[index] == other.numbers[index]

    fun isBallAt(index: Int, other: BallNumbers) =
            !isStrikeAt(index, other) &&
                    numbers.any { it == other.numbers[index] }

    companion object {
        private fun validateNumbersLength(numbers: List<Int>) {
            if (numbers.size != 3) {
                throw IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.")
            }
        }

        private fun validateNumbers(numbers: List<Int>) {
            for (number in numbers) {
                if (number < 1 || number > 9) {
                    throw IllegalArgumentException("BallNumber는 1~9 사이의 3자리 수여야 합니다.")
                }
            }
        }
    }

}
