package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getUserAnswer(): String {
        print(INPUT_MESSAGE)
        return Console.readLine()
    }

    fun getExitInput(): String =
        Console.readLine()

    fun terminated() {
        Console.close()
    }

    companion object {
        private const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
    }
}