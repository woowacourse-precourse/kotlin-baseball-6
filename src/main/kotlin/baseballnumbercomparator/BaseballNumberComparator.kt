package baseballnumbercomparator

fun interface BaseballNumberComparator {
    fun compareAnswerWithPlayerBaseballNumber(answer: String, baseballNumber: String): BaseballResult
}