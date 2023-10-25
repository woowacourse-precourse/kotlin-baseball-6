package baseball

class GamePrint {
    fun startGamePrint() = println("숫자 야구 게임을 시작합니다.")

    fun endGamePrint() = println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

    fun inputUserPrint() = print("숫자를 입력해주세요 : ")

    fun gameOptionPrint() = println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    fun resultPrint(result: Result) = println(result.toMessage())

    private fun Result.toMessage(): String {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱"
        } else{
            var message = ""
            if (ballCount > 0) {
                message += "${ballCount}볼"
            }
            if (strikeCount > 0) {
                if (message.isNotEmpty()) {
                    message += " "
                }
                message += "${strikeCount}스트라이크"
            }
            return message
        }
    }

}