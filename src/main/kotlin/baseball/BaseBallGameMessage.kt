package baseball

class BaseBallGameMessage {
    private val startMessage = "숫자 야구 게임을 시작합니다."
    private val personInputMessage = "숫자를 입력해주세요 : "
    private val nothingMessage = "낫싱"
    private val strikeMessage = "%d스트라이크"
    private val ballMessage = "%d볼"
    private val restartAndExitMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    private val gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    //게임 시작 메시지 출력
    fun printStartMessage() {
        println(startMessage)
    }

    //사용자 입력 메시지 출력
    fun printPersonInputMessage() {
        print(personInputMessage)
    }

    //게임 재시작 여부 메시지 출력
    fun printRestartAndExitMessage() {
        println(restartAndExitMessage)
    }

    //게임 종료 메시지 출력
    fun printGameEndMessage() {
        println(gameEndMessage)
    }

    //볼 스트라이크 카운트 메세지 출력
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