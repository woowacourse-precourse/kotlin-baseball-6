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
}