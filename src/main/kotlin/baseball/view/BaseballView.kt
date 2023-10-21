package baseball.view

import baseball.util.Constant.START_GAME_MESSAGE
import baseball.util.Constant.END_GAME_MESSAGE
import baseball.util.Constant.INPUT_NUMBER_MASSAGE


class BaseballView {
    fun printStartGameMessage() = println(START_GAME_MESSAGE)

    fun printEndGameMessage() = println(END_GAME_MESSAGE)

    fun printInputNumberMessage() = println(INPUT_NUMBER_MASSAGE)
}