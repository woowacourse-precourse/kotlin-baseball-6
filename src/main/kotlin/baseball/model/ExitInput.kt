package baseball.model

import baseball.model.ExitInput.Type.Companion.isEquals

@JvmInline
value class ExitInput(private val input: String) {

    init {
        Validator.validExitInput(input)
    }

    fun isExit(): Boolean = input.isEquals(Type.Exit)

    internal enum class Type(val value: Int) {
        Restart(1), Exit(2);

        companion object {
            fun String.isEquals(type: Type): Boolean =
                runCatching {
                    type.value == this.toInt()
                }.getOrDefault(false)
        }
    }
}