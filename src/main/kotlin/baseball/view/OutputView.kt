package baseball.view

import baseball.util.Constant.START_GAME_MESSAGE
import baseball.util.Constant.END_GAME_MESSAGE
import baseball.util.Constant.BALL_MESSAGE
import baseball.util.Constant.STRIKE_MESSAGE
import baseball.util.Constant.INPUT_NUMBER_MASSAGE
import baseball.util.Constant.RESTART_GAME_MESSAGE


class OutputView {
    fun printStartGameMessage() = println(START_GAME_MESSAGE)

    fun printEndGameMessage() = println(END_GAME_MESSAGE)

    fun printInputNumberMessage() = println(INPUT_NUMBER_MASSAGE)
}