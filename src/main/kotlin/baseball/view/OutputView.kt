package baseball.view

import baseball.model.Score
import utils.Constant.GAME_START_MESSAGE
import utils.Constant.NUMBER_INPUT_MESSAGE

class OutputView {

    fun printGameStartMessage() = println(GAME_START_MESSAGE)

    fun printNumberInputMessage() = print(NUMBER_INPUT_MESSAGE)

    fun printScoreMessage(score: Score) = println(buildString {
        if (score.balls > 0) append("${score.balls}볼 ")
        if (score.strikes > 0) append("${score.strikes}스트라이크")
        if (score.outs == 3) append("낫싱")
    }.trim())

}