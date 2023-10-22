package baseball

class GameNumber(value: Char) {
    private val number: Int

    init {
        require(value in MIN_VALUE..MAX_VALUE) { "${MIN_VALUE}부터 ${MAX_VALUE}까지의 수가 아닙니다." }
        number = value.digitToInt()
    }

    companion object {
        private const val MIN_VALUE = '1'
        private const val MAX_VALUE = '9'
    }
}
