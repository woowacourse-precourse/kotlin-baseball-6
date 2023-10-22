package baseball.domain

enum class GameStatus(private val input: String) {
    REPLAY("1"),
    EXIT("2");

    companion object {
        fun of(input: String) {
            when (input) {
                "1" -> REPLAY
                "2" -> EXIT
                else -> throw IllegalArgumentException("GameStatus는 반드시 1, 2 중 하나를 입력해서 만들 수 있습니다.")
            }
        }
    }
}