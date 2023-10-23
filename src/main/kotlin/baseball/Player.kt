package baseball

import baseball.Constant.Companion.END
import baseball.Constant.Companion.RESTART

class Player {

    fun createPlayerBallNumbers(): List<Int> {
        return readPlayerInputNumbers().map { it.toString().toInt() }
    }

    fun getGameEndDecision(): String {
        return when (readPlayerGameEndDecisionInput()) {
            "1" -> RESTART
            "2" -> END
            else -> ""
        }
    }

    // TODO 예외처리
    private fun readPlayerInputNumbers(): String {
        return readln()
    }

    // TODO 예외처리
    private fun readPlayerGameEndDecisionInput(): String {
        return readln()
    }

}