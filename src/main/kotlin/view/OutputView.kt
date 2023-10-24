package view

object OutputView {
    const val START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다."
    const val PLEASES_INPUT_BASEBALL_NUMBER = "숫자를 입력해 주세요 : "

    fun startBaseballGame() {
        println(START_BASEBALL_GAME)
    }

    fun pleaseInputBaseballNumber() {
        println(PLEASES_INPUT_BASEBALL_NUMBER)
    }
}