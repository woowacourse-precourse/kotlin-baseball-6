package baseball.domain.game

import baseball.domain.player.PlayerNumbers

class BaseballGame(private val computerNumbers: PlayerNumbers) {

    fun play(userNumbers: PlayerNumbers): Pair<Int, Int> {
        var strikes = 0
        var balls = 0

        for (i in userNumbers.indices) {
            when (this.computerNumbers.getBallStatus(i, userNumbers[i])) {
                BallStatus.STRIKE -> strikes++
                BallStatus.BALL -> balls++
                BallStatus.NOTHING -> {}
            }
        }

        return Pair(strikes, balls)
    }
}
