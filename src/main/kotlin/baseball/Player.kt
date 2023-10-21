package baseball

import baseball.Constant.Companion.END
import baseball.Constant.Companion.RESTART

class Player {

    fun createComputerBallNumbers(): List<Int> {
        return readPlayerInput().map { it.toString().toInt() }
    }

    fun getRestartOrEndDecisionResult(): String {
        return if (readPlayerRestartOrEndDecisionInput() == "1") RESTART
        else END
    }

    private fun readPlayerInput(): String {
        return readln()
    }

    private fun readPlayerRestartOrEndDecisionInput(): String {
        return readln()
    }

}