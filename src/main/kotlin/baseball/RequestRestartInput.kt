package baseball

import camp.nextstep.edu.missionutils.Console

fun requestRestartInput(): Boolean {
    showGameInfo(InfoMsgType.RequestRestartInput)
    when (Console.readLine()) {
        "1" -> {
            return true
        }

        "2" -> {
            return false
        }
    }
    throw IllegalArgumentException()
}