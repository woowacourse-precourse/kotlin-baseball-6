package baseball.model

import baseball.config.GameNumberConfig

class NumberComparator {

    fun compare(input: String, answer: List<Int>): BallAndStrike {
        val ballAndStrike = BallAndStrike()
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

}