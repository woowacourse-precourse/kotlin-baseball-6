package baseball.view

import baseball.utils.Constants
import camp.nextstep.edu.missionutils.Console

class ResultView {
    fun printStartMessage() {
        println(Constants.START_MESSAGE)
    }

    fun askForRestart(): Boolean{
        println(Constants.ASK_RESTART_MESSAGE)
        return Console.readLine().toInt() != 2
    }
}