package baseball.domain

import baseball.config.GameNumberConfig

class NumberComparator {

    private val ballAndStrike = BallAndStrike()

    fun compare(input: String, answer: List<Int>): BallAndStrike {
        initBallAndStrike()
        for (i in 0 until GameNumberConfig.DIGIT_NUMBER) {
            if (answer.contains(input[i] - '0')) {
                ballAndStrike.ball++
            }
            if (input[i] - '0' == answer[i]) {
                ballAndStrike.strike++
            }
        }
        ballAndStrike.ball -= ballAndStrike.strike
        return ballAndStrike
    }

    private fun initBallAndStrike() {
        ballAndStrike.ball = 0
        ballAndStrike.strike = 0
    }

}