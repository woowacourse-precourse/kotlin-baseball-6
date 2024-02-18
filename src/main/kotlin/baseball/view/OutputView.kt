package baseball.view

class OutputView {
    companion object {

        fun printJudgeResult(ballCount: Int, strikeCount: Int) {
            if (ballCount > 0) {
                print("${ballCount}볼 ")
            }

            if (strikeCount > 0) {
                print("${strikeCount}스트라이크")
            }

            if (ballCount == 0 && strikeCount == 0) {
                print("낫싱")
            }

            println()
        }

        fun printGameEndMessage(numberSize: Int) {
            println("${numberSize}개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }
    }
}