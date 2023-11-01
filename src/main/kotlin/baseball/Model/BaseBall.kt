package baseball.Model

import baseball.Util.Constants.GAME_NUMBER_LENGTH

class BaseBall {
    private var _strike = 0
    val strike: Int
        get() = _strike

    private var _ball = 0
    val ball: Int
        get() = _ball


    fun compareNumber(computer: List<Int>, user: List<Int>) {
        resetHint()
        for (i in user.indices) {
            if (computer[i] == user[i]) {
                _strike++
            } else if (computer.contains(user[i])) {
                _ball++
            }
        }
    }

    private fun resetHint() {
        _strike = 0
        _ball = 0
    }

    fun gameStatus() = strike != GAME_NUMBER_LENGTH
}