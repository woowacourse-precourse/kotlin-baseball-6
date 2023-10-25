package baseballnumbercomparator

object BaseballNumberComparatorImpl : BaseballNumberComparator {
    private const val ZERO = 0
    private const val ONE_STRIKE = 1
    private const val ONE_BALL = 1

    override fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        val checkContainingNumbersResult = checkContainingNumbers(answer, baseballNumber)
        ball += checkContainingNumbersResult.ball

        val checkNumbersAreInSamePlaceResult = checkNumbersAreInSamePlace(answer, baseballNumber)
        strike += checkNumbersAreInSamePlaceResult.strike
        ball += checkNumbersAreInSamePlaceResult.ball

        return BaseballResult(strike = strike, ball)
    }

    private fun checkContainingNumbers(answer: String, baseballNumber: String): BaseballResult {
        val ball = baseballNumber.count { answer.contains(it) }
        return BaseballResult(ZERO, ball)
    }

    private fun checkNumbersAreInSamePlace(
        answer: String,
        baseballNumber: String
    ): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        answer.forEachIndexed { index, answerNumber ->
            if (answerNumber == baseballNumber[index]) {
                strike += ONE_STRIKE
                ball -= ONE_BALL
            }
        }

        return BaseballResult(strike, ball)
    }
}