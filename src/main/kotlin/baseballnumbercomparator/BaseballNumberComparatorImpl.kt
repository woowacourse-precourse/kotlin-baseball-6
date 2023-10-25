package baseballnumbercomparator

class BaseballNumberComparatorImpl : BaseballNumberComparator {
    override fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult {
        var strike = ZERO
        var ball = ZERO

        return BaseballResult(strike = strike, ball)
    }

    private fun checkContainingNumbers() {

    }

    private fun checkNumbersAreInSamePlace() {

    }

    companion object {
        private const val ZERO = 0
    }
}