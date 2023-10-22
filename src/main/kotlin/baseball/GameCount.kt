package baseball

object GameCount {
    private var ballCount = 0
    private var strikeCount = 0

    fun plusBallCount() {
        ballCount++
    }

    fun plusStrikeCount() {
        strikeCount++
    }

    fun getBallCount() = ballCount

    fun getStrikeCount() = strikeCount

    fun resetCount() {
        ballCount = 0
        strikeCount = 0
    }
}
