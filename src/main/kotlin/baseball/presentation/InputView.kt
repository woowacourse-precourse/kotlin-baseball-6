package baseball.presentation

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPlayerNumber(): String {
        print(ASK_NUMBER)
        val input = Console.readLine()
        return try {
            validatePlayerNumber(input)
            input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readPlayerNumber()
        }
    }

    fun readReGameOrQuitProgram(): String {
        println(ASK_RE_GAME_OR_QUIT_PROGRAM)
        val input = Console.readLine()
        return try {
            validatePlayerNumber(input)
            require(input == "1" || input == "2") { NUMBER_ERROR }
            input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readReGameOrQuitProgram()
        }
    }

    private fun validatePlayerNumber(input: String) =
        requireNotNull(input.toIntOrNull()) { NUMBER_ERROR }

    companion object {
        const val ASK_NUMBER = "숫자를 입력해주세요 : "
        const val ASK_RE_GAME_OR_QUIT_PROGRAM = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        const val NUMBER_ERROR = "[ERROR] 유효하지 않은 숫자입니다. 다시 입력해 주세요."
    }
}