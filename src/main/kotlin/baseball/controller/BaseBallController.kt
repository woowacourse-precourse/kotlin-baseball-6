package baseball.controller

import baseball.model.Computer
import baseball.model.User
import baseball.view.BaseBallView

class BaseBallController {

    val baseBallView = BaseBallView()

    fun playGame(){
        baseBallView.printPlayGame()
        val computer = Computer().makeComputerList()
        baseBallView.printInputUser()
        val user = User().inputUser()

    }
}