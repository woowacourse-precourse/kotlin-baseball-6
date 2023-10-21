package baseball

import baseball.Constant.Companion.END
import baseball.Constant.Companion.RESTART

class Player {

    fun createPlayerBallNumbers(): List<Int> {
        return readPlayerInputNumbers().map { it.toString().toInt() }
    }

    fun getRestartOrEndDecisionResult(): String {
        return if (readPlayerRestartOrEndDecisionInput() == "1") RESTART
        else END
    }

    // TODO 예외처리
    private fun readPlayerInputNumbers(): String {
        return readln()
    }

    // TODO 예외처리
    private fun readPlayerRestartOrEndDecisionInput(): String {
        return readln()
    }

}