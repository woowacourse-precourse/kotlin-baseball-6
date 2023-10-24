package baseball.view

import baseball.domain.BallCount

private const val MAX_STRIKE_COUNT = 3
private const val NOTHING_COUNT = 0

class PrintResultView {

    fun printGameResult(gameResult: Map<BallCount, Int>) {
        if (gameResult[BallCount.STRIKE] == MAX_STRIKE_COUNT) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        printBallCount(gameResult)
    }

    private fun printBallCount(gameResult: Map<BallCount, Int>) {
        if (gameResult[BallCount.STRIKE] == NOTHING_COUNT &&
            gameResult[BallCount.BALL] == NOTHING_COUNT
        ) {
            println("낫싱")
            return
        }
        printRemainBallCount(gameResult)
    }

    private fun printRemainBallCount(gameResult: Map<BallCount, Int>) {
        if (gameResult[BallCount.BALL] != NOTHING_COUNT) {
            print("${gameResult[BallCount.BALL]}볼 ")
        }
        if (gameResult[BallCount.STRIKE] != NOTHING_COUNT) {
            println("${gameResult[BallCount.STRIKE]}스트라이크")
            return
        }
        println()
    }
}