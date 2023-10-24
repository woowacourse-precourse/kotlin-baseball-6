package baseball

data class JudgeResult(
    val ball: Int,
    val strike: Int,
) {
    val isCorrect: Boolean
        get() = (ball == 0) && (strike == 3)

    fun print() {
        val tokens = mutableListOf<String>()
        if (ball == 0 && strike == 0) {
            tokens.add("낫싱")
        }
        if (ball != 0) {
            tokens.add("${ball}볼")
        }
        if (strike != 0) {
            tokens.add("${strike}스트라이크")
        }
        println(tokens.joinToString(separator = " "))
    }
}