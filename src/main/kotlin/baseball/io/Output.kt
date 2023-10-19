package baseball.io

import baseball.constants.BALL
import baseball.constants.NOTHING
import baseball.constants.STRIKE

fun printBallAndStrike(ball: Int, strike: Int) {
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