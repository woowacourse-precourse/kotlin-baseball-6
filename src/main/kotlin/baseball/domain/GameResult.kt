package baseball.domain

enum class GameResult(val statusCode: Boolean) {
    Win(true),
    Lose(false)
}