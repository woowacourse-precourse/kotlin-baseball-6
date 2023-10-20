package baseball.domain

data class BallAndStrike(
        var ball: Int = 0,
        var strike: Int = 0
) {
    override fun toString(): String {
        if (ball == 0 && strike == 0) {
            return "낫싱"
        }
        if (strike == 0) {
            return "${ball}볼"
        }
        if (ball == 0) {
            return "${strike}스트라이크"
        }
        return "${ball}볼 ${strike}스트라이크"
    }
}

