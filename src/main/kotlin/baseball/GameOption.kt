package baseball

enum class GameOption(val value: Int) {
    Restart(1),
    Exit(2);

    companion object {

        fun createOrThrow(input: String): GameOption {
            val number = input.toIntOrNull() ?: throw IllegalArgumentException()
            return when (number) {
                Restart.value -> Restart
                Exit.value -> Exit
                else -> throw IllegalArgumentException()
            }
        }
    }
}
