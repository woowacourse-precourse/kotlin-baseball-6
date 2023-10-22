package baseball.view

import baseball.domain.BallResult

class OutputView {
    fun printResult(result: BallResult) {
        if (result.ballCount + result.strikeCount == 0) {
            print("낫싱")
        }
        if (result.ballCount > 0) {
            print("${result.ballCount}볼 ")
        }
        if (result.strikeCount > 0) {
            print("${result.strikeCount}스트라이크")
        }
        println()
    }
}