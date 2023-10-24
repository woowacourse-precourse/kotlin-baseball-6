package baseball.domain

import java.util.*

class BallCountResult {
    private var ballCountResult: MutableMap<BallCount, Int> = EnumMap(BallCount::class.java)

    init {
        ballCountResult[BallCount.BALL] = 0
        ballCountResult[BallCount.STRIKE] = 0
    }

    fun addStrike() {
        ballCountResult[BallCount.STRIKE] = ballCountResult[BallCount.STRIKE]!! + 1
    }

    fun addBall() {
        ballCountResult[BallCount.BALL] = ballCountResult[BallCount.BALL]!! + 1
    }

    fun strikeCount(): Int {
        return ballCountResult[BallCount.STRIKE]!!
    }

    fun ballCount(): Int {
        return ballCountResult[BallCount.BALL]!!
    }
}