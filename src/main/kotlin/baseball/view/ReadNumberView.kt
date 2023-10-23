package baseball.view

import camp.nextstep.edu.missionutils.Console

private const val MIN_VALUE = 100
private const val MAX_VALUE = 999

class ReadNumberView {

    fun readUserNumberInput(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }

}