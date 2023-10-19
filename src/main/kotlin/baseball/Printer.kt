package baseball

class Printer {

    fun printWelcome() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printBye() {
        println("게임 종료")
    }

    fun printTypeNumber() {
        print("숫자를 입력해주세요 : ")
    }

    fun printFinishInGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printGameOption() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printJudgeResult(judgeResult: JudgeResult) {
        val message = judgeResult.toMessage()
        println(message)
    }

    private fun JudgeResult.toMessage(): String {
        if (balls == 0 && strikes == 0) {
            return "낫싱"
        }
        var message = ""
        if (balls > 0) {
            message += "${balls}볼"
        }
        if (strikes > 0) {
            if (message.isNotEmpty()) {
                message += " "
            }
            message += "${strikes}스트라이크"
        }
        return message
    }
}
