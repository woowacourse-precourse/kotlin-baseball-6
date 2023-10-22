package baseball

class GameNumbers(value: String?) {
    private val numbers: List<GameNumber>

    init {
        validateInput(value)
        numbers = value!!.map { GameNumber(it) }
    }

    private fun validateInput(value: String?) {
        requireNotNull(value) { "입력값이 null입니다." }
        require(value.length == SIZE) { "입력값의 길이가 ${SIZE}이 아닙니다." }
        require(value.toSet().size == SIZE) { "입력값에 중복되는 문자가 있습니다." }
    }

    companion object {
        private const val SIZE = 3
    }
}
