package baseball.model

class MatchUp(private val pitcher: PlayingNumber) {

    fun play(userNumber: String): Score {
        val playingNumber = PlayingNumber.of(userNumber)

        val strikes = playingNumber.countStrike(pitcher)
        val balls = playingNumber.countBall(pitcher)

        return Score(strikes, balls)
    }

}
