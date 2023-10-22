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

    fun getBallCount() : Int {
        return ballCount
    }
    fun getStrikeCount() : Int{
        return strikeCount
    }

    fun resetCount() {
        ballCount = 0
        strikeCount = 0
    }
}
