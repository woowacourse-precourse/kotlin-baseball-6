package baseball

import baseball.BaseballResult.*

class BaseballGame {

    private val console: BaseballConsole by lazy {
        BaseballConsole()
    }
    private val engine: BaseballEngine by lazy {
        BaseballEngine()
    }

    init {
        console.printWelcomeMessage()
    }

    fun start(computerNumber: BaseballNum? = null) {
        val computer = computerNumber ?: engine.generateRandomNumber()
        val userInput = console.getInput()
        produceResult(computer, userInput.toBaseballNum())
    }

    private fun produceResult(computer: BaseballNum, userInput: BaseballNum) {
        val result = engine.compare(computer, userInput)
        console.printResult(result)
        when (result) {
            is BaseballResult.Nothing,
            is Ball,
            is Strike,
            is BallAndStrike -> start(computer)

            is Success -> end()
        }
    }

    private fun end() {
        console.printEndMessage()
        when (console.getEndFlag()) {
            EndFlag.FINISH -> return
            EndFlag.RESTART -> start()
        }
    }
}
