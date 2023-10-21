package baseball.constants

enum class GuideMessage(val msg: String) {
    GAME_START("숫자 야구 게임을 시작합니다."),
    ENTER_NUMBER("숫자를 입력해주세요 : "),
    RESTART_OR_FINISH("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
}