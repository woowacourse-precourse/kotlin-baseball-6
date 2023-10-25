package baseball

import camp.nextstep.edu.missionutils.Console

class Baseball(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {
    private val pitcher: Pitcher = Pitcher(numberCount, minNumber, maxNumber)
    private val batter: Batter = Batter(numberCount, minNumber, maxNumber)
    private val referee: Referee = Referee()
    private val validator: Validator = Validator()
    private var gameCommand = 1

    init {
        printStartMessage()
    }

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    fun runGame() {
        while (true) {
            if (gameCommand == 1) playInning()
            else if (gameCommand == 2) break
            getGameCommand()
        }
    }

    private fun playInning() {
        pitcher.generateNumbers()
        print(pitcher.getNumbers())
        do {
            batter.enterNumbers()
            referee.judge(pitcher.getNumbers(), batter.getNumbers())
            println(referee.getResultMessage())
        } while (referee.getResultMessage() != "3스트라이크")

        printEndMessage()
    }

    private fun printEndMessage() {
        val message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        println(message)
    }

    private fun getGameCommand() {
        val userInput = enteredInput()
        gameCommand = formatChangedCommand(userInput)
    }

    private fun enteredInput(): String {
        val message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

        println(message)
        return Console.readLine()
    }

    private fun formatChangedCommand(input: String): Int {
        validator.validateCommand(input)
        return Character.getNumericValue(input.first())
    }
}
