package baseball.view

import camp.nextstep.edu.missionutils.Console
class InputView {

    fun getInputNumber() : String{
        val input = Console.readLine()
        InputValidator.validateInputLength(input)
        InputValidator.validateInputNumber(input)
        InputValidator.validateInputDuplicate(input)
        return input
    }
    fun getRestartOption() = Console.readLine().toInt()
}
