package baseball.io

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

const val BALL = "볼"
const val STRIKE = "스트라이크"
const val NOTHING = "낫싱"