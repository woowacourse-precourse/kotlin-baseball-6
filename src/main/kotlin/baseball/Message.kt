package baseball

object Message {
    const val GUIDE_START = "숫자 야구 게임을 시작합니다."
    const val GUIDE_INPUT = "숫자를 입력해주세요 : "
    const val GUIDE_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val GUIDE_DECISION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    const val ERROR_LENGTH = "올바른 범위가 아닙니다."
    const val ERROR_NUMBER = "숫자가 아닌 문자가 존재합니다."
    const val ERROR_ZERO = "0이 포함 되면 안됩니다."
    const val ERROR_DUPLICATION = "중복된 숫자가 존재합니다."
    const val ERROR_DECISION = "1 또는 2를 입력하세요."

    const val SCORE_BALL = "볼"
    const val SCORE_STRIKE = "스트라이크"
    const val SCORE_NOTHING = "낫싱"
}