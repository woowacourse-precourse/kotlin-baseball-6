package baseball.domain

import baseball.view.InputView

class GameProcessor {

    fun startGameProcess(numberSize: Int): Boolean {
        val computer = Computer(numberSize)
        val judge = Judge()

        while (true) {
            val userNumbers = InputView.inputUserNumbers(numberSize)
            val gameResult = judge.judgeGameResult(numberSize, computer.numbers, userNumbers)
            if (gameResult) break
        }

        return InputView.isReStart()
    }
}