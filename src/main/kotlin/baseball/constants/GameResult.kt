package baseball.constants

enum class GameResult(val message: String) {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    override fun toString(): String {
        return this.message
    }
}