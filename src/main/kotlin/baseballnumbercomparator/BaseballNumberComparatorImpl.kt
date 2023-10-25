package baseballnumbercomparator

class BaseballNumberComparatorImpl : BaseballNumberComparator {
    override fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        val checkContainingNumbersResult = checkContainingNumbers(answer,baseballNumber, ball)
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
                ball += 1
            }
        }
        return BaseballResult(0, ball)
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
                strike += 1
                ball -= 1
            }
        }
        return BaseballResult(strike, ball)
    }

    companion object {
        private const val ZERO = 0
    }
}