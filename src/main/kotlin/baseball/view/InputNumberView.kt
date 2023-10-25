package baseball.view

import baseball.config.GameMsg.ENTER_NUMBER
import camp.nextstep.edu.missionutils.Console

class InputNumberView {
    fun inputNumber(): String {
        print(ENTER_NUMBER)
        return Console.readLine()
    }
}