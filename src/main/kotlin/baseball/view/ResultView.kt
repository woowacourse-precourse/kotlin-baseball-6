package baseball.view

import baseball.domain.GameLogic
import baseball.utils.Constants
import camp.nextstep.edu.missionutils.Console

class ResultView {
    fun printStartMessage() {
        println(Constants.START_MESSAGE)
    }

    fun askForRestart(): Boolean {
        println(Constants.ASK_RESTART_MESSAGE)
        return Console.readLine().toInt() != 2
    }

    fun printResultView(gameLogic: GameLogic, strikes: Int, balls: Int) {
        val resultMessage = gameLogic.getResultMessage(strikes, balls)
        println(resultMessage)
    }
}