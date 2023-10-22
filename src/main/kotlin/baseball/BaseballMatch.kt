package baseball

import baseball.BaseBallComment.BALL_COMMENT
import baseball.BaseBallComment.NOTHING_COMMENT
import baseball.BaseBallComment.STRIKE_COMMENT
import baseball.Comment.END_COMMENT
import baseball.Comment.GAME_STOP_COMMENT
import baseball.Comment.SPACE
import baseball.Number.ZERO
import baseball.model.MatchResult

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
        user.map { userNum ->
            if (userNum in computer) {
                ball++
            }
        }
    }

    private fun countStrike(user: String) {
        user.mapIndexed { index, userNum ->
            if (computer[index] == userNum) {
                strike++
                ball--
            }
        }
    }

    private fun matchResult(): MatchResult {
        if (strike == 3) {
            println(strike.toString() + STRIKE_COMMENT)
            println(GAME_STOP_COMMENT)
            println(END_COMMENT)
            return MatchResult.SUCCEED
        }

        if (strike == 0 && ball == 0) {
            println(NOTHING_COMMENT)
            return MatchResult.FAIL
        }

        if (strike == 0) {
            println(ball.toString() + BALL_COMMENT)
            return MatchResult.FAIL
        }

        if (ball == 0) {
            println(strike.toString() + STRIKE_COMMENT)
            return MatchResult.FAIL
        }

        println(ball.toString() + BALL_COMMENT + SPACE + strike + STRIKE_COMMENT)
        return MatchResult.FAIL
    }
}