package baseball.domain

class Answer(numbers: List<BallNumber>) : BallNumbers(numbers) {

    fun compareTo(guess: Guess): BallResult {
        return BallResult(
            countStrikes(guess),
            countBalls(guess),
        )
    }

    private fun countStrikes(guess: Guess) =
        (0..<BALL_COUNT).count { isStrikeAt(it, guess) }

    private fun countBalls(guess: Guess) =
        (0..<BALL_COUNT).count { isBallAt(it, guess) }

    private fun isStrikeAt(index: Int, other: Guess) =
        numbers[index] == other.getAt(index)

    private fun isBallAt(index: Int, other: Guess) =
        !isStrikeAt(index, other) &&
                numbers.any { it == other.getAt(index) }

}
