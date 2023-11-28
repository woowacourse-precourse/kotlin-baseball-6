package baseball.view

enum class Command(val commandName: String, val command: Int) {
    RESTART("새로 시작", 1),
    EXIT("종료", 2),
    NONE("잘못된 입력", -1)
}