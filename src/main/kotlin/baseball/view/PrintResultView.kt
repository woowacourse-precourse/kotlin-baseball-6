package baseball.view

import baseball.domain.BallCount

private const val MAX_STRIKE_COUNT = 3
private const val NOTHING_COUNT = 0

class PrintResultView {

    fun printGameResult(gameResult: Map<BallCount, Int>) {
        if (gameResult[BallCount.Strike] == MAX_STRIKE_COUNT) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        } else {
            if (gameResult[BallCount.Strike] == NOTHING_COUNT &&
                gameResult[BallCount.Ball] == NOTHING_COUNT
            ) {
                println("낫싱")
            } else {
                if (gameResult[BallCount.Ball] != NOTHING_COUNT) {
                    print("${gameResult[BallCount.Ball]}볼 ")
                }
                if (gameResult[BallCount.Strike] != NOTHING_COUNT) {
                    println("${gameResult[BallCount.Strike]}스트라이크")
                } else {
                    println()
                }
            }
            return
        }
    }
}