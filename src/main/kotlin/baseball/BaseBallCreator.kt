package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseBallCreator {
    fun createAnswerBalls(): List<Int> {
        return mutableListOf<Int>().apply {
            while (size < BALL_LIMIT) {
                val randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
                if (contains(randomNumber).not()) add(randomNumber)
            }
        }
    }

    private companion object {
        const val BALL_LIMIT = 3
        const val START_NUMBER = 1
        const val END_NUMBER = 9
    }
}