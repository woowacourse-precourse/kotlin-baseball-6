package baseball.presentation

import baseball.domain.model.JudgeResult

class OutputView {
    fun printStart() = println("숫자 야구 게임을 시작합니다.")


    fun printResult(result: JudgeResult) {
        val message = mutableListOf<String>()
        if (result.nothing) message.add("낫싱")
        if (result.ball >= 1) message.add("${result.ball}볼")
        if (result.strike >= 1) message.add("${result.strike}스트라이크")
        println(message.joinToString(" "))
    }

    fun printEnd() = println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}