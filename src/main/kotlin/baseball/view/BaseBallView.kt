package baseball.view

import baseball.INPUT_USER_MESSAGE
import baseball.START_MESSAGE
import baseball.STRIKE_MESSAGE

class BaseBallView {
    fun printPlayGame() = println(START_MESSAGE)
    fun printInputUser() = print(INPUT_USER_MESSAGE)

    fun printBaseBallResult(strike: Int, ball: Int) {
        if (strike != 0) {
            println("$strike$STRIKE_MESSAGE")
        }
    }
}