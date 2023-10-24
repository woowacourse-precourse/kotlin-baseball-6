package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class BaseballGameModel {


    var computerBalls: Balls = getRandomBalls()
    var isExit: Boolean = false

    private fun getRandomBalls(): Balls {
        val numList: MutableList<Int> = mutableListOf()
        while (numList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber)
            }
        }
        return Balls(numList = numList)
    }

    fun calculateScore(userBalls: Balls): Score {
        var strike = 0
        var ball = 0

        for (i in 0 until Balls.MAX_BALLS) {
            if (userBalls[i] == computerBalls[i]) {
                strike++
            } else if (computerBalls.contains(userBalls[i])) {
                ball++
            }
        }
        return Score(strike = strike, ball = ball)
    }


    fun reset() {
        computerBalls = getRandomBalls()
    }

}