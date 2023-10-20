package baseball

class Printer {

    fun printWelcome() {
        println(Messages.Welcome)
    }

    fun printBye() {
        println(Messages.Bye)
    }

    fun printTypeNumber() {
        print(Messages.TypeNumber)
    }

    fun printFinishInGame() {
        println(Messages.FinishInGame)
    }

    fun printGameOption() {
        println(Messages.GameOption)
    }

    fun printJudgeResult(judgeResult: JudgeResult) {
        val message = judgeResult.toMessage()
        println(message)
    }

    private fun JudgeResult.toMessage(): String {
        if (balls == 0 && strikes == 0) {
            return Messages.Nothing
        }
        var message = ""
        if (balls > 0) {
            message += "${balls}${Messages.Ball}"
        }
        if (strikes > 0) {
            if (message.isNotEmpty()) {
                message += " "
            }
            message += "${strikes}${Messages.Strike}"
        }
        return message
    }
}
