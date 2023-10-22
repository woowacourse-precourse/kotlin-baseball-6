package baseball.domain

enum class GameStatus(private val input: String) {
    REPLAY("1"),
    EXIT("2"),

    // 그 외 문자가 입력된 경우 UNKNOWN을 반환하여 알려줌
    UNKNOWN("_");

    companion object {
        fun of(input: String) =
                when (input) {
                    "1" -> REPLAY
                    "2" -> EXIT
                    // "1", "2"가 아니면 UNKNOWN 반환
                    else -> UNKNOWN
                }
    }
}