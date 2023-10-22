package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun setComputerNumber(): MutableList<Int> {
        val computer = mutableListOf<Int>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        return computer
    }

    fun countStrikeAndBall(computer: MutableList<Int>, user: MutableList<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0

        user.forEach {
            if (computer.contains(it)) {
                ball++
            }
        }

        for (i in user.indices) {
            if (user[i] == computer[i]) {
                strike++
                ball--
            }
        }

        return Pair(strike, ball)
    }

    fun checkGameState(strike: Int): Boolean {
        if (strike == 3) {
            return false
        }
        return true
    }
}