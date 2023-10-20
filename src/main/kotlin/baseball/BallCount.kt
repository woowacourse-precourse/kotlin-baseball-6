package baseball

data class BallCount(val strike: Int, val ball: Int) {
    fun isNothing() = (strike + ball) == 0
    fun isStrikeOut() = strike == 3
    override fun toString(): String =
        if (isNothing()) "낫싱"
        else if (ball == 0) "${strike}스트라이크"
        else if (strike == 0) "${ball}볼"
        else "${ball}볼 ${strike}스트라이크"
}