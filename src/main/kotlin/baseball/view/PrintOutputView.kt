package baseball.view

import baseball.constant.PrintText
import baseball.domain.BallCountResult

class PrintOutputView {
    fun printStartGame() {
        println(PrintText.START_GAME.text)
    }

    fun printRequireNumber() {
        print(PrintText.INPUT_NUMBER.text)
    }

    fun printRequireRestart() {
        println(PrintText.INPUT_RESTART.text)
    }

    fun printGameResult(gameResult: BallCountResult) {
        if (gameResult.countStrike() == MAX_STRIKE_COUNT) {
            println(PrintText.THREE_STRIKE.text)
            println(PrintText.GAME_FINISHED.text)
            return
        }
        printBallCount(gameResult)
    }

    private fun printBallCount(gameResult: BallCountResult) {
        if (gameResult.countStrike() == NOTHING_COUNT &&
            gameResult.countBall() == NOTHING_COUNT
        ) {
            println(PrintText.NOTHING.text)
            return
        }
        printRemainBallCount(gameResult)
    }

    private fun printRemainBallCount(gameResult: BallCountResult) {
        if (gameResult.countBall() != NOTHING_COUNT) {
            print("${gameResult.countBall()}" + PrintText.BALL_NUM.text)
        }
        if (gameResult.countStrike() != NOTHING_COUNT) {
            println("${gameResult.countStrike()}" + PrintText.STRIKE_NUM.text)
            return
        }
        println()
    }

    companion object {
        private const val MAX_STRIKE_COUNT = 3
        private const val NOTHING_COUNT = 0
    }
}