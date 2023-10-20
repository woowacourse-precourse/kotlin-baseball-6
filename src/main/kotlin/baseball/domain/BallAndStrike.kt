package baseball.domain

data class BallAndStrike(
    var ball: Int = 0,
    var strike: Int = 0,
) {
    override fun toString(): String = when {
        ball == 0 && strike == 0 -> "낫싱"
        strike == 0 -> "${ball}볼"
        ball == 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }
}