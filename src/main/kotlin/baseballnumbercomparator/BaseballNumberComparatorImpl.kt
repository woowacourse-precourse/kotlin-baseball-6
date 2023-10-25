package baseballnumbercomparator

object BaseballNumberComparatorImpl : BaseballNumberComparator {
    private const val ZERO = 0
    private const val ONE_STRIKE = 1
    private const val ONE_BALL = 1

    override fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        val checkContainingNumbersResult = checkContainingNumbers(answer, baseballNumber, ball)
        ball = checkContainingNumbersResult.ball

        val checkNumbersAreInSamePlaceResult = checkNumbersAreInSamePlace(answer, baseballNumber, strike, ball)
        strike = checkNumbersAreInSamePlaceResult.strike
        ball = checkNumbersAreInSamePlaceResult.ball

        return BaseballResult(strike = strike, ball)
    }

    private fun checkContainingNumbers(answer: String, baseballNumber: String, currentBall: Int): BaseballResult {
        var ball = currentBall
        for (index in 0..2) {
            if (answer.contains(baseballNumber[index])) {
                ball += ONE_BALL
            }
        }
        return BaseballResult(ZERO, ball)
    }

    private fun checkNumbersAreInSamePlace(
        answer: String,
        baseballNumber: String,
        currentStrike: Int,
        currentBall: Int
    ): BaseballResult {
        var strike = currentStrike
        var ball = currentBall

        for (index in 0..2) {
            if (answer[index] == baseballNumber[index]) {
                strike += ONE_STRIKE
                ball -= ONE_BALL
            }
        }
        return BaseballResult(strike, ball)
    }
}