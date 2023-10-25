package baseball

import baseball.model.Result

class View {

    fun printStartMessage() = println(START_MESSAGE)

    fun inputUserNumber(): List<Int> {
        print(REQUEST_INPUT_MESSAGE)
        val input = readln()
        // todo 모두 숫자인지 여부 예외처리
        return input.map { it.toString().toInt() }
    }

    fun printResult(result: Result) {
        var output = ""
        if (result.ball > 0) {
            output += "${result.ball}$BALL "
        }
        if (result.strike > 0) {
            output += "${result.strike}$STRIKE"
        }
        if (result.strike == 0 && result.ball == 0) {
            output = NOTHING
        }
        println(output)
    }

    fun printCorrectMessage() = println(CORRECT_MESSAGE)

    fun questPlayingGame(): Boolean {
        println(END_GAME_MESSAGE)
        return when (readln()) {
            "1" -> true
            "2" -> false
            else -> throw IllegalArgumentException(INPUT_ERROR)
        }
    }

    companion object {
        private const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : "
        private const val BALL = "볼"
        private const val STRIKE = "스트라이크"
        private const val NOTHING = "낫싱"
        private const val CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        private const val END_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val INPUT_ERROR = "1 혹은 2만 입력해주세요"
    }
}
