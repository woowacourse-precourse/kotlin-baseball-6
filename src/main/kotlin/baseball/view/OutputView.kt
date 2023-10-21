package baseball.view

import baseball.util.GameMessage

class OutputView {

    fun printGameStartMessage() = println(GameMessage.GAME_START_MESSAGE)
    fun printGameInputMessage() = println(GameMessage.GAME_INPUT_NUMBER_MESSAGE)
    fun printGameSuccessMessage() = println(GameMessage.GAME_SUCCESS_MESSAGE+" "+GameMessage.GAME_OVER_MESSAGE)
    fun printGameEndMessage() = println(GameMessage.GAME_END_MESSAGE)
    //TODO 숫자 비교 결과 메시지 출력 N볼 N스트라이크 or 낫싱
}