package baseball.View

import baseball.Util.Validator
import baseball.makeIntList
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun decideGameStatus(): Int {
        val userInput = getUserInput()
        Validator.validateGameStatus(userInput)
        return userInput.toInt()
    }

    fun getUserInputList(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val userInput = getUserInput()
        Validator.validateLength(userInput)
        Validator.validateInteger(userInput)
        Validator.validateRange(userInput)
        Validator.validateUniqueNumber(userInput)
        return makeIntList(userInput)
    }

    fun getUserInput(): String {
        return Console.readLine()
    }
}