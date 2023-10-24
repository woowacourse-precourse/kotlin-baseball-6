package controller

import model.RandomNumberCreate
import view.BaseballInputView

class BaseballGameController {
    public fun GameStart() {
        BaseballInputView().printStartGameMessage()
        var computerNumber = ""
        computerNumber = RandomNumberCreate().createRandomNumber()
    }
}