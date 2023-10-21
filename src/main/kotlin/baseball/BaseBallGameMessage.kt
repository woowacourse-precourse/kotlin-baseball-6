package baseball

class BaseBallGameMessage {
    private val startMessage = "숫자 야구 게임을 시작합니다."
    private val personInputMessage = "숫자를 입력해주세요 : "
    private val nothingMessage = "낫싱"
    private val strikeMessage = "%d스트라이크"
    private val ballMessage = "%d볼"
    private val restartAndExitMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    fun printStartMessage() {
        println(startMessage)
    }

    fun printPersonInputMessage() {
        print(personInputMessage)
    }

    fun printRestartAndExitMessage() {
        println(restartAndExitMessage)
    }

    fun printCountMessage(strike: Int, ball: Int) {
        when {
            strike == 0 && ball == 0
                -> println(nothingMessage)
            strike == 0
                -> println(ballMessage.format(ball))
            ball == 0
                -> println(strikeMessage.format(strike))
            strike == 3
                -> println(strikeMessage.format(strike))
            else
                -> println("${ballMessage.format(ball)} ${strikeMessage.format(strike)}")
        }
    }

}