package baseball.view

import baseball.model.GameResult

class OutputView {

    fun printGameStart() {
        println(Message.Start)
    }

    fun printGameClear() {
        println(Message.Clear)
    }

    fun printResult(gameResult: GameResult) {
        println(gameResult)
    }

    private enum class Message(private val message: String) {
        Start("숫자 야구 게임을 시작합니다."),
        Clear("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        override fun toString(): String = message
    }
}