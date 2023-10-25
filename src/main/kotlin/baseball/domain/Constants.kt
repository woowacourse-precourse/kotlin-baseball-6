package baseball.domain

object Constants {
    // Game
    const val NUMBER_SIZE = 3
    val DIGIT_RANGE = 1..9
    const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
    const val INPUT_MESSAGE = "숫자를 입력해주세요: "
    const val GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val GAME_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    //Ball Status
    const val NOTHING = "낫싱"
    const val STRIKE = "스트라이크"
    const val BALL = "볼"

    // Error Messages
    const val EMPTY_INPUT_ERROR_MESSAGE = "입력값이 없습니다."
    const val NOT_NUMBER_ERROR_MESSAGE = "입력값이 숫자가 아닙니다."
    const val NOT_RETRY_TYPE_ERROR_MESSAGE = "1 또는 2를 입력해주세요."
    const val LENGTH_ERROR_MESSAGE = "입력값은 3자리여야 합니다."
    const val DUPLICATED_ERROR_MESSAGE = "입력값에 중복되는 숫자가 있습니다."
    const val INVALID_DIGIT_ERROR_MESSAGE = "입력된 각 자리의 숫자는 1부터 9까지 여야 합니다."
}
