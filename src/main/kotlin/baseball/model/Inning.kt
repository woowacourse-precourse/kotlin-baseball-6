package baseball.model

class Inning(private val pitcher: PlayingNumber) {

    fun matchUp(userNumber: String): Score {
        val playingNumber = PlayingNumber.of(userNumber)

        val strikes = playingNumber.countStrike(pitcher)
        val balls = playingNumber.countBall(pitcher)

        return Score(strikes, balls)
    }

}
