package baseball

data class BallCount(val strike: Int, val ball: Int) {
    fun isNothing(): Boolean {
        return strike == 0 && ball == 0
    }

    fun isThreeStrike(): Boolean {
        return strike == 3
    }
}
