package baseball.util

object GameMessage {
    const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
    const val GAME_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
    const val GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! "
    const val GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    const val GAME_OVER_MESSAGE = "게임 종료"
    const val GAME_ERROR_INPUT_LENGTH = "입력은 3글자입니다."
    const val GAME_ERROR_INPUT_NUMBER = "입력은 1~9로 구성되어야 합니다."
    const val GAME_ERROR_INPUT_DUPLICATE = "입력은 서로 다른 숫자로 구성되어야 합니다."
}