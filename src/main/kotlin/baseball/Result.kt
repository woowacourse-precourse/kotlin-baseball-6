package baseball

data class Result(
    var ball: Int = 0,
    var strike: Int = 0
) {
    fun sumResult(): Int = ball + strike
}