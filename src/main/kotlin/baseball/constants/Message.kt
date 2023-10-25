package baseball.constants

object Message {
    const val GAME_START = "숫자 야구 게임을 시작합니다."
    const val GAME_END = "${GameConfig.BASEBALL_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료"

    const val INPUT_BASEBALL = "숫자를 입력해주세요 : "
    const val INPUT_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    const val RESULT_NOTHING = "낫싱"
    const val RESULT_ALL_STRIKE = "${GameConfig.BASEBALL_DIGITS}스트라이크"
}