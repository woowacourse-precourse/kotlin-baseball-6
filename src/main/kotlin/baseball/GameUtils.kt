package baseball

object GameUtils {
    fun isAnswer(strikeCount: Int) = strikeCount == 3

    private fun isSamePositionAndValue(answer: List<Int>, index: Int, value: Char): Boolean {
        return answer[index].toString() == value.toString()
    }

    private fun isDiffPositionAndContainValue(answer: List<Int>, index: Int, value: Char): Boolean {
        return answer[index].toString() != value.toString() && answer.contains(value - '0')
    }

    fun countBall(answer: List<Int>, input: String): Int {
        var ballCount = 0
        input.forEachIndexed { index, c ->
            if (isDiffPositionAndContainValue(answer, index, c)) {
                ballCount += 1
            }
        }
        return ballCount
    }

    fun countStrike(answer: List<Int>, input: String): Int {
        var strikeCount = 0

        input.forEachIndexed { index, c ->
            if (isSamePositionAndValue(answer, index, c)) {
                strikeCount += 1
            }
        }

        return strikeCount
    }

    fun trialResultMessage(strikeCount: Int, ballCount: Int): String {
        return if (isAnswer(strikeCount)) "$strikeCount$TRIAL_RESULT_STRIKE_MESSAGE"
        else if (strikeCount == 0 && ballCount == 0) TRIAL_RESULT_NOTHING_MESSAGE
        else if (ballCount > 0 && strikeCount > 0) "$ballCount$TRIAL_RESULT_BALL_MESSAGE $strikeCount$TRIAL_RESULT_STRIKE_MESSAGE"
        else if (ballCount == 0) "$strikeCount$TRIAL_RESULT_STRIKE_MESSAGE"
        else "$ballCount$TRIAL_RESULT_BALL_MESSAGE"
    }
}