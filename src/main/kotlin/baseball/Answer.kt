package baseball

object Answer {
    private var _number: IntArray = intArrayOf()
    val number: IntArray get() = _number
    internal fun newGenerator() {
        _number = answerSelect()
    }
}