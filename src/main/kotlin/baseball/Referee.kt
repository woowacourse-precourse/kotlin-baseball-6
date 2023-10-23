package baseball

import baseball.constants.GameResult

class Referee {
    private val resultMap = mutableMapOf<GameResult, Int>()
    private val ballCount get() = resultMap.getOrDefault(GameResult.BALL, 0)
    private val strikeCount get() = resultMap.getOrDefault(GameResult.STRIKE, 0)

    fun determineGameResult(answerBaseBalls: List<Int>, baseBalls: List<Int>): String {
        if (isWin(answerBaseBalls, baseBalls)) return THREE_STRIKE
        increaseBallCount(answerBaseBalls, baseBalls)
        if (isNothing()) return NOTHING
        val result = mergeResult(ballCount, strikeCount)
        resultMap.clear()
        return result
    }

    private fun increaseBallCount(answerBaseBalls: List<Int>, baseBalls: List<Int>) {
        for (idx in baseBalls.indices) {
            val num = baseBalls[idx]
            if (isStrike(answerBaseBalls[idx], num)) {
                increaseCount(GameResult.STRIKE)
                continue
            }
            if (isBall(answerBaseBalls, num)) {
                increaseCount(GameResult.BALL)
            }
        }
    }

    private fun mergeResult(ballCnt: Int, strikeCnt: Int): String {
        return StringBuilder().apply {
            if (ballCnt > 0) {
                append("$ballCnt")
                append(GameResult.BALL.message)
                append(EMPTY_SPACE)
            }
            if (strikeCnt > 0) {
                append("$strikeCnt")
                append(GameResult.STRIKE.message)
            }
        }.toString()
    }

    private fun isWin(answerBalls: List<Int>, userBalls: List<Int>) = answerBalls == userBalls
    private fun isStrike(answerBall: Int, userBall: Int) = answerBall == userBall
    private fun isBall(answerBalls: List<Int>, userBall: Int) = userBall in answerBalls
    private fun isNothing() =
        ballCount + strikeCount == 0

    private fun increaseCount(result: GameResult) {
        resultMap += result to resultMap.getOrDefault(result, 0) + 1
    }

    companion object {
        private const val EMPTY_SPACE = " "
        private const val THREE_STRIKE = "3스트라이크"
        private const val NOTHING = "낫싱"
    }
}