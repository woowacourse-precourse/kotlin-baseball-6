package view

import util.Message.Constant.END_GAME_MESSAGE
import util.Message.Constant.INPUT_NUMBER_MASSAGE
import util.Message.Constant.RESTART_GAME_MESSAGE
import util.Message.Constant.START_GAME_MESSAGE

class BaseballInputView {
    fun printStartGameMessage() = println(START_GAME_MESSAGE)

    fun printInputNumberMessage() = print(INPUT_NUMBER_MASSAGE)

    fun printRestartGameMessage() = println(RESTART_GAME_MESSAGE)

    fun printEndGameMessage() = println(END_GAME_MESSAGE)
}