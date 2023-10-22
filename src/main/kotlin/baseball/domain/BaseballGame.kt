package baseball.domain

class BaseballGame(private val answer: BallNumbers) {

    fun play(guess: BallNumbers) =
            BallResult(strikeCount(guess), ballCount(guess))

    private fun strikeCount(guess: BallNumbers): Int {
        var count = 0

        for (i in 1..3) {
            val isStrike = answer.isStrikeAt(i, guess)
            if (isStrike) {
                count++
            }
        }

        return count
    }

    private fun ballCount(guess: BallNumbers): Int {
        var count = 0

        for (i in 1..3) {
            val isBall = answer.isBallAt(i, guess)
            if (isBall) {
                count++
            }
        }

        return count
    }
}