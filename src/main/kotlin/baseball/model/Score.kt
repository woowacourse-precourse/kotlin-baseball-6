package baseball.model

import baseball.constants.BALL
import baseball.constants.BASEBALL_SIZE
import baseball.constants.NOTHING
import baseball.constants.STRIKE

class Score(private val ball: Int, private val strike: Int) {
    fun printBallAndStrike() {

        if (ball > 0 && strike > 0) {
            println("$ball$BALL $strike$STRIKE")
            return
        }
        if (ball > 0) {
            println("$ball$BALL")
            return
        }
        if (strike > 0) {
            println("$strike$STRIKE")
            return
        }
        println(NOTHING)
    }

    fun isEndGame() = strike == BASEBALL_SIZE

}