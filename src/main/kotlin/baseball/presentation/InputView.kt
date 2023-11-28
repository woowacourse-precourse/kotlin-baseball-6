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

    private fun validatePlayerNumber(input: String) =
        requireNotNull(input.toIntOrNull()) { NUMBER_ERROR }

    companion object {
        const val ASK_NUMBER = "숫자를 입력해주세요 : "
        const val NUMBER_ERROR = "[ERROR] 유효하지 않은 숫자입니다. 다시 입력해 주세요."
    }
}