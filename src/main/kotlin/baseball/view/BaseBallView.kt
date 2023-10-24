package baseball.view

import baseball.*

class BaseBallView {
    fun printPlayGame() = println(START_MESSAGE)
    fun printInputUser() = print(INPUT_USER_MESSAGE)
    fun printGameOver() = println(GAME_OVER_MESSAGE)
    fun printContinue() = println(CHECK_CONTINUE_MESSAGE)


    fun printBaseBallResult(strike: Int, ball: Int) {
        if (ball == 0 && strike == 0) {
            println(NOTING_MESSAGE)
        } else if (ball != 0 && strike == 0) {
            println("$ball$BALL_MESSAGE")
        } else if (ball != 0) {
            print("$ball$BALL_MESSAGE ")
        } else {
            println("$strike$STRIKE_MESSAGE")
        }
    }
}