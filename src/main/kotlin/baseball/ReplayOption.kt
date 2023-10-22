package baseball

enum class ReplayOption {
    REPLAY,
    EXIT,
    ;

    companion object {
        private const val REPLAY_VALUE = "1"
        private const val EXIT_VALUE = "2"

        fun from(value: String?): ReplayOption {
            requireNotNull(value) { "입력값이 null입니다." }
            return when (value) {
                REPLAY_VALUE -> REPLAY
                EXIT_VALUE -> EXIT
                else -> throw IllegalArgumentException("입력값이 $REPLAY_VALUE 또는 ${EXIT_VALUE}가 아닙니다.")
            }
        }
    }
}
