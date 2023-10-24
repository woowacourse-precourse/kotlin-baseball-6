package view

object OutputView {
    const val START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다."
    const val PLEASES_INPUT_BASEBALL_NUMBER = "숫자를 입력해 주세요 : "
    const val STRIKE = "스트라이크"
    const val BALL = "볼"
    const val NOTHING = "낫싱"
    const val ZERO = 0

    fun startBaseballGame() {
        println(START_BASEBALL_GAME)
    }

    fun pleaseInputBaseballNumber() {
        println(PLEASES_INPUT_BASEBALL_NUMBER)
    }

    fun intermediateResult(strike: Int, ball: Int) {
        when {
            strike > ZERO && ball > ZERO -> println("${ball}$BALL ${strike}$STRIKE")
            strike > ZERO -> println("${strike}$STRIKE")
            ball > ZERO -> println("${ball}$BALL")
            strike == ZERO && ball == ZERO -> println(NOTHING)
        }
    }
}