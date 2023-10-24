package controller

import camp.nextstep.edu.missionutils.Console
import model.RandomNumberCreate
import validation.UserInputValidation
import view.BaseballInputView

class BaseballGameController {
    public fun GameStart() {
        BaseballInputView().printStartGameMessage()
        var computerNumber = ""
        computerNumber = RandomNumberCreate().createRandomNumber()
        UserNumber()
    }

    private fun UserNumber() {
        BaseballInputView().printInputNumberMessage()
        var userNumber = Console.readLine()
        UserInputValidation().inputLength(userNumber)
    }
}