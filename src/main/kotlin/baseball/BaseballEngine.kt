package baseball

import baseball.BaseballResult.*
import baseball.BaseballResult.Nothing
import camp.nextstep.edu.missionutils.Randoms

class BaseballEngine(private val comparator: BaseballComparator) {

    private val maxSize = 3

    fun generateRandomNumber(): String {
        return getRandomList().joinToString("")
    }

    private fun getRandomList(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < maxSize) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    fun compare(computer: String, user: String): BaseballResult {
        if (computer.length != maxSize || user.length != maxSize) {
            throw IllegalArgumentException()
        }

        val (strike, ball) = comparator.compare(computer, user)

        return if (ball + strike == 0) {
            Nothing
        } else if (ball == 0) {
            val result = Strike(strike)
            if (strike == maxSize) {
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