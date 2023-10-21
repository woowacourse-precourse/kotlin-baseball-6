package baseball

import baseball.BaseballResult.*
import camp.nextstep.edu.missionutils.Randoms

class BaseballEngine {
    fun generateRandomNumber(): BaseballNum {
        val numbers = getRandomList()
        return BaseballNum(numbers[0], numbers[1], numbers[2])
    }

    private fun getRandomList(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    fun compare(computer: BaseballNum, user: BaseballNum): BaseballResult {
        val (c1, c2, c3) = computer
        val (u1, u2, u3) = user
        var ball = 0
        var strike = 0

        when (u1) {
            c1 -> strike++
            c2 -> ball++
            c3 -> ball++
        }

        when (u2) {
            c1 -> ball++
            c2 -> strike++
            c3 -> ball++
        }

        when (u3) {
            c1 -> ball++
            c2 -> ball++
            c3 -> strike++
        }

        return if (ball + strike == 0) {
            Nothing
        } else if (ball == 0) {
            val result = Strike(strike)
            if (strike == 3) {
                Success(result)
            } else {
                result
            }
        } else if (strike == 0) {
            Ball(ball)
        } else {
            BallAndStrike(Ball(ball), Strike(strike))
        }
    }
}