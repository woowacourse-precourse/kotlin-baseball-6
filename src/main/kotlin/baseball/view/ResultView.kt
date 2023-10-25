package baseball.view

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

    fun printResultCount(strikes: Int, balls: Int) {
        when (balls) {
            0 -> when (strikes) {
                0 -> println(Constants.NOTHING_MESSAGE)
                else -> println("$strikes" + Constants.STRIKE_MESSAGE)
            }

            else -> when (strikes) {
                0 -> println("$balls" + Constants.BALL_MESSAGE)
                else -> println("$balls" + Constants.BALL_MESSAGE + " $strikes" + Constants.STRIKE_MESSAGE)
            }
        }
    }
}