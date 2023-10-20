package baseball.view

import camp.nextstep.edu.missionutils.Console
import baseball.utils.Exception.userWrongDuplicationAnswer
import baseball.utils.Exception.userWrongSizeAnswer
import baseball.utils.Exception.userWrongTypeAnswer

class InputView {

    fun getInputNumber(): String {
        val number: String = Console.readLine()

        number.userWrongTypeAnswer()
        number.userWrongSizeAnswer()
        number.userWrongDuplicationAnswer()

        return number
    }

    fun getInputBaseballRestart(): String = Console.readLine()

}