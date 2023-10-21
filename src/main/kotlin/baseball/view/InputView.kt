package baseball.view

import camp.nextstep.edu.missionutils.Console
import baseball.view.OutputView

class InputView {
    fun inputNumber(): String {
        val inputNumber = Console.readLine()
        checkLength(inputNumber)
        checkIsDigit(inputNumber)
        checkDifferentNumber(inputNumber)

        return inputNumber
    }

    fun callException(): Nothing = throw IllegalArgumentException("잘못")

    fun checkLength(inputNumber: String) {
        if (inputNumber.length != 3) {
            callException()
        }
    }

    fun checkDifferentNumber(inputNumber: String) {
        if (inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
            callException()
        }
    }

    fun checkIsDigit(inputNumber: String) {
        inputNumber.forEach {
            if (49 > it.code || 57 < it.code) callException()
        }
    }
}