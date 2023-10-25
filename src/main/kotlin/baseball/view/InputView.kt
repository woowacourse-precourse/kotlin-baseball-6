package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun userInputNum(): Int {
        print("숫자를 입력하세요: ")
        val input = Console.readLine()

        if (input.length != 3 || !input.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }
}