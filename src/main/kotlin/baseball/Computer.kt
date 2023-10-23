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

        for (i in user.indices) {
            if (computer[i] == user[i]) {
                strike++
            } else if (computer.contains(user[i])) {
                ball++
            }
        }

        return Pair(strike, ball)
    }

    fun checkGameState(strike: Int): Boolean {
        return strike == 3
    }
}