package baseball.controller

import baseball.view.BaseBallView

class BaseBall {

    val baseBallView = BaseBallView()

    fun playGame(){
        baseBallView.printPlayGame()
    }
}