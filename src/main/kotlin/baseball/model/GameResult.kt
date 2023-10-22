package baseball.model

class GameResult(computerAnswer: Answer, userAnswer: Answer) {

    private val ball: Int
    private val strike: Int

    init {
        val (ball, strike) = calculate(computerAnswer, userAnswer)
        this.ball = ball
        this.strike = strike
    }

    fun isAllStrike(): Boolean = this.strike == 3

    override fun toString(): String {
        if (ball == 0 && strike == 0) {
            return ResultMessage.Nothing.toString()
        }

        return buildString {
            if (ball > 0) append(ball).append(ResultMessage.Ball).append(' ')
            if (strike > 0) append(strike).append(ResultMessage.Strike)
        }
    }

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

    private enum class ResultMessage(private val message: String) {
        Nothing("낫싱"),
        Ball("볼"),
        Strike("스트라이크");

        override fun toString(): String = message
    }
}