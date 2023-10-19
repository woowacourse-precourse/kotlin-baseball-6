package baseball

data class JudgeResult(
    val strikes: Int = 0,
    val balls: Int = 0
) {
    init {
        require(strikes >= 0)
        require(balls >= 0)
        require(strikes + balls <= BaseballNumber.NUMBER_SIZE)
    }
}
