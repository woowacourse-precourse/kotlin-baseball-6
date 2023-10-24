package baseball.view

import baseball.model.Hint

class OutputView {

    fun printGameStart() {
        println(Message.Start)
    }

    fun printGameClear() {
        println(Message.Clear)
    }

    fun printHint(hint: Hint) {
        println(hint.toMessage())
    }

    private fun Hint.toMessage(): String {
        if (ball == 0 && strike == 0) {
            return HintMessage.Nothing.message
        }

        return buildString {
            if (ball > 0) append(ball).append(HintMessage.Ball.message).append(' ')
            if (strike > 0) append(strike).append(HintMessage.Strike.message)
        }
    }

    private enum class Message(private val message: String) {
        Start("숫자 야구 게임을 시작합니다."),
        Clear("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        override fun toString(): String = message
    }

    private enum class HintMessage(val message: String) {
        Nothing("낫싱"),
        Ball("볼"),
        Strike("스트라이크");
    }
}