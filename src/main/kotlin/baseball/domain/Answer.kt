package baseball.domain

class Answer(numbers: List<BallNumber>) : BallNumbers(numbers) {

    fun countStrikes(guess: Guess) =
        (0..<BALL_COUNT).count { isStrikeAt(it, guess) }

    fun countBalls(guess: Guess) =
        (0..<BALL_COUNT).count { isBallAt(it, guess) }

    private fun isStrikeAt(index: Int, other: Guess) =
        numbers[index] == other.getAt(index)

    private fun isBallAt(index: Int, other: Guess) =
        !isStrikeAt(index, other) &&
                numbers.any { it == other.getAt(index) }

}
