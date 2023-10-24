package baseball.view

import baseball.model.BaseballResult
import baseball.util.Constant.START_GAME_MESSAGE
import baseball.util.Constant.END_GAME_MESSAGE
import baseball.util.Constant.INPUT_NUMBER_MASSAGE
import baseball.util.Constant.RESTART_GAME_MESSAGE


class BaseballView {
    fun printStartGameMessage() = println(START_GAME_MESSAGE)

    fun printEndGameMessage() = println(END_GAME_MESSAGE)

    fun printInputNumberMessage() = print(INPUT_NUMBER_MASSAGE)

    fun printRestartGameMessage() = println(RESTART_GAME_MESSAGE)

    fun printHintMessage(baseballResult: BaseballResult) = println(buildString {
        if (baseballResult.balls > 0) append("${baseballResult.balls}볼 ")
        if (baseballResult.strikes > 0) append("${baseballResult.strikes}스트라이크")
        if (baseballResult.nothing == 3) append("낫싱")
    })
}