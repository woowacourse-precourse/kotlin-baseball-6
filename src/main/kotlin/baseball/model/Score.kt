package baseball.model

class Score(ball: Int, strike: Int) {
    private var strike: Int
    private var ball: Int

    init {
        require(strike >= 0) { "strike $strike 가 양수가 아닙니다." }
        require(ball >= 0) { "ball $ball 가 양수가 아닙니다." }
        this.strike = strike
        this.ball = ball
    }

    override fun toString(): String {
        var message: String = ""
        if (ball != 0){
            message += "$ball 볼 "
        }
        if (strike != 0){
            message += "$strike 스트라이크 "
        }

        return message.ifEmpty {
            "낫띵"
        }
    }
}