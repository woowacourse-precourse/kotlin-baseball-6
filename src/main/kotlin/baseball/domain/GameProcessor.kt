package baseball.domain

import baseball.view.InputView
import baseball.view.OutputView

class GameProcessor (private val numberSize: Int) {

    fun startGameProcess(): Boolean {
        val computer = Computer(numberSize)
        val judge = Judge()

        while (true) {
            val userNumbers = InputView.inputUserNumbers(numberSize)

            val strikeCount = judge.judgeStrike(numberSize, computer.numbers, userNumbers)
            val ballCount = judge.judgeBall(numberSize, computer.numbers, userNumbers)

            OutputView.printJudgeResult(ballCount, strikeCount)

            if (judge.isGameOver(strikeCount, numberSize)) break
        }

        return !InputView.isReStart()
    }
}