package view

object OutputView {
    private const val START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다."
    private const val PLEASES_INPUT_BASEBALL_NUMBER = "숫자를 입력해 주세요 : "
    private const val GUESSED_ALL_BASEBALL_NUMBER_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    private const val RESTART_OR_TERMINATE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    private const val STRIKE = "스트라이크"
    private const val BALL = "볼"
    private const val NOTHING = "낫싱"
    private const val ZERO = 0

    fun startBaseballGame() {
        println(START_BASEBALL_GAME)
    }

    fun pleaseInputBaseballNumber() {
        print(PLEASES_INPUT_BASEBALL_NUMBER)
    }

    fun guessedAllBaseballNumber() {
        println(GUESSED_ALL_BASEBALL_NUMBER_GAME_OVER)
    }

    fun restartOrTerminateGame() {
        println(RESTART_OR_TERMINATE_GAME)
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