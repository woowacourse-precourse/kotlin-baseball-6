package baseball.domain

import baseball.constant.BallCount
import java.util.*

class BallCountResult {
    private var ballCountResult: MutableMap<BallCount, Int> = EnumMap(BallCount::class.java)

    init {
        ballCountResult[BallCount.BALL] = INIT_COUNT
        ballCountResult[BallCount.STRIKE] = INIT_COUNT
    }

    fun addStrike() {
        ballCountResult[BallCount.STRIKE] = ballCountResult[BallCount.STRIKE]!! + INCREASE_COUNT
    }

    fun addBall() {
        ballCountResult[BallCount.BALL] = ballCountResult[BallCount.BALL]!! + INCREASE_COUNT
    }

    fun countStrike(): Int {
        return ballCountResult[BallCount.STRIKE]!!
    }

    fun countBall(): Int {
        return ballCountResult[BallCount.BALL]!!
    }

    companion object {
        private const val INIT_COUNT = 0
        private const val INCREASE_COUNT = 1
    }
}