package baseball.controller

import baseball.model.Computer
import baseball.view.BaseBallView

class BaseBallController {

    val baseBallView = BaseBallView()

    fun playGame(){
        baseBallView.printPlayGame()
        val computer = Computer().makeComputerList()

    }
}