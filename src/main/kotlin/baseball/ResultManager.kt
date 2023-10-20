package baseball

import baseball.Constants.BALL
import baseball.Constants.NOTHING
import baseball.Constants.STRIKE
import baseball.Constants.SUCCESS

class ResultManager(
    private val target: MutableList<Int>,
    private val answer: MutableList<Int>
) {
    private lateinit var gameResult: GameResult

    fun checkAnswer(): Boolean {
        var currentStrike = 0
        var currentBall = 0
        target.zip(answer) { targetNum, answerNum ->
            if (targetNum == answerNum) {
                currentStrike++
            } else if (targetNum in answer) {
                currentBall++
            } else { }
        }

        gameResult = GameResult(strike = currentStrike, ball = currentBall)

        return getResult(gameResult)
    }

    private fun getResult(gameResult: GameResult): Boolean {
        val strike = gameResult.strike
        val ball = gameResult.ball

        return if (strike == 3) {
            println("$strike$STRIKE")
            println(SUCCESS)
            true
        } else {
            logFailure(strike, ball)
            false
        }
    }

    private fun logFailure(strike: Int, ball: Int) {
        if (strike > 0 && ball > 0) {
            println("$ball$BALL $strike$STRIKE")
        } else if (gameResult.strike > 0) {
            println("$strike$STRIKE")
        } else if (gameResult.ball > 0) {
            println("$ball$BALL")
        } else {
            println(NOTHING)
        }
    }
}