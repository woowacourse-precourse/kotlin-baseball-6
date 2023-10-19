package baseball

class Printer {

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
