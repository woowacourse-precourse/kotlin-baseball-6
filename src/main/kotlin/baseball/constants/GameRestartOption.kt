package baseball.constants

enum class GameRestartOption {
    INIT,
    RESTART,
    EXIT;

    companion object {
        fun of(signal: String): GameRestartOption {
            return when (signal) {
                "1" -> RESTART
                "2" -> EXIT
                else -> throw IllegalArgumentException()
            }
        }
    }
}