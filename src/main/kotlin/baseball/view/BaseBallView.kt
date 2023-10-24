package baseball.view

import baseball.BALL_MESSAGE
import baseball.INPUT_USER_MESSAGE
import baseball.START_MESSAGE
import baseball.STRIKE_MESSAGE

class BaseBallView {
    fun printPlayGame() = println(START_MESSAGE)
    fun printInputUser() = print(INPUT_USER_MESSAGE)

    fun printBaseBallResult(strike: Int, ball: Int) {
        if (ball != 0 && strike == 0) {
            println("$ball$BALL_MESSAGE")
        } else {
            print("$ball$BALL_MESSAGE ")
        }
        if (strike != 0) {
            println("$strike$STRIKE_MESSAGE")
        }
    }
}