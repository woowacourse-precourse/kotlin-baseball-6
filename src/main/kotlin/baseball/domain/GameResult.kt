package baseball.domain

enum class GameResult(val statusCode: Boolean) {
    WIN(true),
    LOSE(false)
}