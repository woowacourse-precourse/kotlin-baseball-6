package baseball.presentation

import baseball.domain.model.JudgeResult

class OutputView {
    fun printStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printResult(result: JudgeResult) {
        println("${result.strike} ${result.ball} ${result.nothing}")
    }

    fun printEnd() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}