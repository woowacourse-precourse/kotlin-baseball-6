package baseball.game

import baseball.util.Constants.LENGTH_NUMBER
import baseball.util.Constants.NO_BALL
import baseball.util.Constants.NO_STRIKE

class GameResult(
    private val computer: MutableList<Int>,
    private val player: MutableList<Int>
) {

    private var ball = NO_BALL
    private var strike = NO_STRIKE

    init {
        calculate()
    }

    private fun calculate() {
        val idx = 0
        (idx until LENGTH_NUMBER).forEach {
            compare(it)
        }
    }

    private fun compare(idx: Int) {
        when {
            computer[idx] == player[idx] -> strike++
            computer.contains(player[idx]) -> ball++
        }
    }

    fun print() {
        when {
            (ball == NO_BALL && strike == NO_STRIKE) -> println("낫싱")
            (ball != NO_BALL && strike == NO_STRIKE) -> println("${ball}볼")
            (ball == NO_BALL && strike != NO_STRIKE) -> println("${strike}스트라이크")
            else -> println("${ball}볼 ${strike}스트라이크")
        }
    }

    fun getBallAndStrike(): Pair<Int, Int> {
        return Pair(ball, strike)
    }
}