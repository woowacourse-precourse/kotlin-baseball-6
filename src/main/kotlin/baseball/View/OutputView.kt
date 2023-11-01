package baseball.View

import baseball.Model.BaseBall

class OutputView {
    fun printGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printHint(baseBall: BaseBall) {
        val strike = baseBall.strike
        val ball = baseBall.ball

        val result = when {
            strike == 0 && ball == 0 -> "낫싱"
            strike > 0 && ball == 0 -> "${strike}스트라이크"
            strike == 0 && ball > 0 -> "${ball}볼"
            else -> "${ball}볼 ${strike}스트라이크"
        }

        println(result)
    }

    fun printGameStart() {
        println("숫자 야구 게임을 시작합니다.")
    }
}