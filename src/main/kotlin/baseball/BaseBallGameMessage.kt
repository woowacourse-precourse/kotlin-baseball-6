package baseball

class BaseBallGameMessage {
    private val startMessage: String = "숫자 야구 게임을 시작합니다."
    private val personInputMessage: String = "숫자를 입력해주세요 : "

    fun printStartMessage() {
        println(startMessage)
    }

    fun printPersonInputMessage() {
        print(personInputMessage)
    }

    fun printCountMessage(strike: Int, ball: Int) {
        when {
            strike == 0 && ball == 0
                -> println("낫싱")
            strike == 0
                -> println("${ball}볼")
            ball == 0
                -> println("${strike}스트라이크")
            strike == 3
                -> println("${strike}스트라이크")
            else
                -> println("${ball}볼 ${strike}스트라이크")
        }
    }

}