package baseball

data class Result(
    val strikeCount: Int = 0,
    val ballCount: Int = 0
) {
    val userSuccess: Boolean get() = strikeCount == 3
}
