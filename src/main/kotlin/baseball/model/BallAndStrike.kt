package baseball.model

import baseball.config.GameMsg.BALL
import baseball.config.GameMsg.NOTING
import baseball.config.GameMsg.STRIKE

data class BallAndStrike(
    var ball: Int = 0,
    var strike: Int = 0,
) {
    override fun toString(): String = when {
        ball == 0 && strike == 0 -> NOTING
        strike == 0 -> "$ball" + BALL
        ball == 0 -> "$strike" + STRIKE
        else -> "$ball$BALL $strike$STRIKE"
    }
}