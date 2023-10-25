package baseball.view

class InputView {
    fun printPlayGame() = println(START_MESSAGE)
    fun printInputUser() = print(INPUT_USER_MESSAGE)
    fun printContinue() = println(CHECK_CONTINUE_MESSAGE)

    companion object {
        const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val INPUT_USER_MESSAGE = "숫자를 입력해주세요 : "
        const val CHECK_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}