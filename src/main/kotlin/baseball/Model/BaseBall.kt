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
            isStrike(computer, user, index = i)
            isBall(computer, user, index = i)
        }
    }

    private fun resetHint() {
        _strike = 0
        _ball = 0
    }

    fun gameStatus() = strike != GAME_NUMBER_LENGTH

    private fun isStrike(computer: List<Int>, user: List<Int>, index: Int) {
        if (computer[index] == user[index]) {
            _strike++
        }
    }

    private fun isBall(computer: List<Int>, user: List<Int>, index: Int) {
        if (computer[index] != user[index] && computer.contains(user[index])) {
            _ball++
        }

    }
}