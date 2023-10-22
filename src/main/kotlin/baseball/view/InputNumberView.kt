package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputNumberView {
    fun inputNumber(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }
}