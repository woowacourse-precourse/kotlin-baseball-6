package baseball


class Player {

    fun createPlayerBallNumbers(): List<Int> {
        return readPlayerInputNumbers().map { it.toString().toInt() }
    }

    fun getGameEndDecision(): String {
        return readPlayerGameEndDecisionInput()
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