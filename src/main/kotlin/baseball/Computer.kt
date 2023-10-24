package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    companion object {
        private const val START_NUMBER = 1
        private const val SIZE = 3
        private const val END_NUMBER = 9
    }

    fun setComputerNumber(): MutableList<Int> {
        val computer = mutableListOf<Int>()

        while (computer.size < SIZE) {
            val randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
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
        return strike == SIZE
    }
}