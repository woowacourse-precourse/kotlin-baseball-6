package baseball.view


private const val END_STRIKE = 3

class OutputView {

    fun printStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printEndMessage() {
        println("${END_STRIKE}스트라이크")
        println("${END_STRIKE}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printNothing() {
        println("낫싱")
    }

    fun printResult(ball: Int, strike: Int) {
        println("${ball}볼 ${strike}스트라이크")
    }
}
