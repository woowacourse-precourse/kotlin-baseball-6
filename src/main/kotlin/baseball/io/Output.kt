package baseball.io

class Output {

    fun printStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun askNumber() {
        print("숫자를 입력해주세요 : ")
    }
    fun printBallAndStrike(ball:Int, strike:Int) {
        println("${ball}볼 ${strike}스트라이크")
    }

    fun printBall(ball:Int) {
        println("${ball}볼")
    }

    fun printStrike(strike:Int) {
        println("${strike}스트라이크")
    }

    fun printSuccessMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        printRetryMessage()
    }

    private fun printRetryMessage() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}