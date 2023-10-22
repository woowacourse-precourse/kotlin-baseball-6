package baseball

data class BallCount(val strike: Int, val ball: Int) {
    fun isThreeStrike() = strike == 3

    fun getMessage(): String {
        return when {
            isNothing() -> MessageConstants.NOTHING
            isBallOnly() -> MessageConstants.BALL_ONLY.format(ball)
            isStrikeOnly() -> MessageConstants.STRIKE_ONLY.format(strike)
            else -> MessageConstants.BALL_STRIKE.format(ball, strike)
        }
    }

    private fun isNothing() = strike == 0 && ball == 0

    private fun isStrikeOnly() = ball == 0 && strike > 0

    private fun isBallOnly() = strike == 0 && ball > 0
}
