package baseball

import baseball.constants.GameResult

class Referee {
    fun determineGameResult(answerBaseBalls: List<Int>, baseBalls: List<Int>): String {
        val (ballCount, strikeCount) = calculateBallAndStrikeCount(answerBaseBalls, baseBalls)
        return generateGameResult(ballCount, strikeCount)
    }

    private fun calculateBallAndStrikeCount(answerBaseBalls: List<Int>, baseBalls: List<Int>): Pair<Int, Int> {
        var ballCount = 0
        var strikeCount = 0
        for (idx in baseBalls.indices) {
            val userBall = baseBalls[idx]
            if (isStrike(answerBaseBalls[idx], userBall)) {
                strikeCount++
                continue
            }
            if (isBall(answerBaseBalls, userBall)) {
                ballCount++
            }
        }
        return ballCount to strikeCount
    }

    private fun generateGameResult(ballCount: Int, strikeCount: Int): String {
        if (isNothing(ballCount + strikeCount)) return GameResult.NOTHING.message
        return StringBuilder().apply {
            if (ballCount > 0) {
                append("$ballCount${GameResult.BALL.message}$EMPTY_SPACE")
            }
            if (strikeCount > 0) {
                append("$strikeCount${GameResult.STRIKE.message}")
            }
        }.toString()
    }

    private fun isNothing(totalCount: Int) = totalCount == 0
    private fun isStrike(answerBall: Int, userBall: Int) = answerBall == userBall
    private fun isBall(answerBalls: List<Int>, userBall: Int) = userBall in answerBalls

    companion object {
        private const val EMPTY_SPACE = " "
    }
}