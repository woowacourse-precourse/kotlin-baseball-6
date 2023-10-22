package baseball.model

class ExitInput(input: String) {

    private val type: Type

    init {
        type = valid(input)
    }

    fun isExit(): Boolean = type == Type.Exit

    private fun valid(input: String): Type =
        runCatching {
            Type.get(input.toInt())
        }.getOrElse {
            throw IllegalArgumentException("1 또는 2의 숫자만 입력할 수 있습니다.")
        }

    private enum class Type(val value: Int) {
        Restart(1), Exit(2);

        companion object {
            fun get(value: Int): Type =
                entries.first { it.value == value }
        }
    }
}