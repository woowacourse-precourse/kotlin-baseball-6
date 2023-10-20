package baseball.view

import camp.nextstep.edu.missionutils.Console
import utils.Exception.userWrongDuplicationAnswer
import utils.Exception.userWrongSizeAnswer
import utils.Exception.userWrongTypeAnswer

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