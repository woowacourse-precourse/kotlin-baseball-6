package baseball.view

import baseball.model.Score
import baseball.util.GameMessage
import java.lang.StringBuilder

class OutputView {

    fun printGameStartMessage() = println(GameMessage.GAME_START_MESSAGE)
    fun printGameInputMessage() = print(GameMessage.GAME_INPUT_NUMBER_MESSAGE)
    fun printGameSuccessMessage() = println(GameMessage.GAME_SUCCESS_MESSAGE+" "+GameMessage.GAME_OVER_MESSAGE)
    fun printGameEndMessage() = println(GameMessage.GAME_END_MESSAGE)
    fun printGameScoreMessage(score: Score){
        val str = StringBuilder()
        if(score.out)
            str.append("낫싱")
        if(score.ball!=0)
            str.append("${score.ball}볼 ")
        if(score.strike!=0)
            str.append("${score.strike}스트라이크")
        println(str)
    }
}