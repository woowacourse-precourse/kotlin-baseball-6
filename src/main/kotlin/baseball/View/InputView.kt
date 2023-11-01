package baseball.View

import baseball.Util.Validator
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun decideGameStatus(): String {
        val userInput = getUserInput()
        Validator.validateGameStatus(userInput)
        return userInput
    }

    fun getUserInputList(): String {
        val userInput = getUserInput()
        Validator.validateLength(userInput)
        Validator.validateInteger(userInput)
        Validator.validateRange(userInput)
        Validator.validateUniqueNumber(userInput)
        return userInput
    }

    fun getUserInput(): String {
        return Console.readLine()
    }
}