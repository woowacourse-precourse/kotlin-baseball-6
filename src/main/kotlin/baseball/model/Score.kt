package baseball.model

class Score(ball: Int, strike: Int) {
    val strike: Int
    val ball: Int

    init {
        require(strike >= 0) { "strike $strike 가 양수가 아닙니다." }
        require(ball >= 0) { "ball $ball 가 양수가 아닙니다." }
        this.strike = strike
        this.ball = ball
    }
}