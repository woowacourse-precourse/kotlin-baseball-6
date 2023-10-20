package baseball

import camp.nextstep.edu.missionutils.Console

class GameLooper(
    private val printer: Printer = Printer()
) {

    private fun runInGame() {
        val computer = BaseballNumber.random()
        while (true) {
            printer.printTypeNumber()
            val input = Console.readLine()
            val user = BaseballNumber.createOrThrow(input)
            val judgeResult = computer.judge(user)
            printer.printJudgeResult(judgeResult)
            if (judgeResult.isFinished) {
                break
            }
        }
        printer.printFinishInGame()
    }

    private fun runReady(): GameOption {
        printer.printGameOption()
        val input = Console.readLine()
        return GameOption.createOrThrow(input)
    }

    fun start() {
        printer.printWelcome()
        while (true) {
            runInGame()
            val selectedOption = runReady()
            if (selectedOption == GameOption.Exit) {
                break
            }
        }
        printer.printBye()
    }
}
