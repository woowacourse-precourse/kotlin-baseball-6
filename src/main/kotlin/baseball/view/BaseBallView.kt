package baseball.view

import baseball.INPUT_USER_MESSAGE
import baseball.START_MESSAGE

class BaseBallView {
    fun printPlayGame() = println(START_MESSAGE)
    fun printInputUser() = print(INPUT_USER_MESSAGE)
}