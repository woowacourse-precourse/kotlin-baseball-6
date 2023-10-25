package baseballnumbercomparator

class BaseballNumberComparatorImpl : BaseballNumberComparator {
    override fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        val checkContainingNumbersResult = checkContainingNumbers(answer,baseballNumber, ball)
        ball = checkContainingNumbersResult.ball
        
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

    private fun checkNumbersAreInSamePlace() {

    }

    companion object {
        private const val ZERO = 0
    }
}