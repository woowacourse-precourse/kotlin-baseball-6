package baseball.view

import baseball.domain.BallCountResult

class PrintOutputView {
    fun printStartGame() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printGameResult(gameResult: BallCountResult) {
        if (gameResult.strikeCount() == MAX_STRIKE_COUNT) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        printBallCount(gameResult)
    }

    private fun printBallCount(gameResult: BallCountResult) {
        if (gameResult.strikeCount() == NOTHING_COUNT &&
            gameResult.ballCount() == NOTHING_COUNT
        ) {
            println("낫싱")
            return
        }
        printRemainBallCount(gameResult)
    }

    private fun printRemainBallCount(gameResult: BallCountResult) {
        if (gameResult.ballCount() != NOTHING_COUNT) {
            print("${gameResult.ballCount()}볼 ")
        }
        if (gameResult.strikeCount() != NOTHING_COUNT) {
            println("${gameResult.strikeCount()}스트라이크")
            return
        }
        println()
    }

    companion object {
        private const val MAX_STRIKE_COUNT = 3
        private const val NOTHING_COUNT = 0
    }
}