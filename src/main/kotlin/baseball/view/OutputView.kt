package baseball.view

class OutputView {
    fun printGameOver() = println(GAME_OVER_MESSAGE)

    fun printBaseBallResult(strike: Int, ball: Int) {
        if (ball == 0 && strike == 0) {
            println(NOTING_MESSAGE)
        } else if (ball != 0 && strike == 0) {
            println("$ball$BALL_MESSAGE")
        } else if (ball != 0) {
            print("$ball$BALL_MESSAGE ")
        }
        if (strike != 0) {
            println("$strike$STRIKE_MESSAGE")
        }
    }

    companion object {
        const val STRIKE_MESSAGE = "스트라이크"
        const val BALL_MESSAGE = "볼"
        const val NOTING_MESSAGE = "낫싱"
        const val GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
}