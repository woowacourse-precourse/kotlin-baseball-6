package baseball.domain

import baseball.model.MatchResult
import baseball.utils.BaseBallComment.BALL_COMMENT
import baseball.utils.BaseBallComment.NOTHING_COMMENT
import baseball.utils.BaseBallComment.STRIKE_COMMENT
import baseball.utils.Comment.BR
import baseball.utils.Comment.END_COMMENT
import baseball.utils.Comment.GAME_STOP_COMMENT
import baseball.utils.Comment.SPACE
import baseball.utils.Number.THREE
import baseball.utils.Number.ZERO

class BaseballMatch(
    private val computer: String
) {

    private var ball: Int = ZERO
    private var strike: Int = ZERO

    fun matchComputerUserNumber(user: String): MatchResult {
        resetBallCount()
        countBalls(user)
        countStrike(user)

        return matchResult()
    }

    private fun resetBallCount() {
        ball = ZERO
        strike = ZERO
    }

    private fun countBalls(user: String) {
        user.forEach { userNum ->
            if (userNum in computer) {
                ball++
            }
        }
    }

    private fun countStrike(user: String) {
        user.forEachIndexed { index, userNum ->
            if (computer[index] == userNum) {
                strike++
                ball--
            }
        }
    }

    private fun matchResult(): MatchResult {
        if (strike == THREE) {
            return MatchResult.Success(strike.toString() + STRIKE_COMMENT + BR + GAME_STOP_COMMENT + BR + END_COMMENT)
        }

        if (strike == ZERO && ball == ZERO) {
            return MatchResult.Fail(NOTHING_COMMENT)
        }

        if (strike == ZERO) {
            return MatchResult.Fail(ball.toString() + BALL_COMMENT)
        }

        if (ball == ZERO) {
            return MatchResult.Fail(strike.toString() + STRIKE_COMMENT)
        }

        return MatchResult.Fail(ball.toString() + BALL_COMMENT + SPACE + strike + STRIKE_COMMENT)
    }
}