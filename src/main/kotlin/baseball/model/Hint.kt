package baseball.model

class Hint(computerAnswer: Answer, userAnswer: Answer) {

    val ball: Int
    val strike: Int

    init {
        val (ball, strike) = calculate(computerAnswer, userAnswer)
        this.ball = ball
        this.strike = strike
    }

    fun isAllStrike(): Boolean = strike == 3

    private fun calculate(computerAnswer: Answer, userAnswer: Answer): Pair<Int, Int> {
        var ball = 0
        var strike = 0

        computerAnswer.forEachIndexed { index, number ->
            if (userAnswer[index] == number) {
                strike++
            } else if (userAnswer.contains(number)) {
                ball++
            }
        }

        return Pair(ball, strike)
    }
}