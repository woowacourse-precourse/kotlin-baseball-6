package baseball.view

import baseball.domain.BallResult

class OutputView {
    fun printResult(result: BallResult) {
        if (result.ballCount + result.strikeCount == 0) {
            print("낫싱")
        }
        if (result.ballCount > 0) {
            System.out.printf("%d볼", result.ballCount)
        }
        if (result.strikeCount > 0) {
            System.out.printf("%d스트라이크", result.strikeCount)
        }
        println()
    }
}