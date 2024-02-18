package baseball.domain

import baseball.view.InputView
import baseball.view.OutputView

class GameProcessor {

    fun startGameProcess(numberSize: Int): Boolean {
        val computer = Computer(numberSize)

        while (true) {
            val userNumbers = InputView.inputUserNumbers(numberSize)
            val gameResult = judgeGameResult(numberSize, computer.numbers, userNumbers)
            if (gameResult) break
        }

        return InputView.isReStart()
    }

    private fun judgeGameResult(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Boolean {
        val judge = Judge()
        val strikeCount = judge.judgeStrike(numberSize, computerNumbers, userNumbers)
        val ballCount = judge.judgeBall(numberSize, computerNumbers, userNumbers)
        OutputView.printJudgeResult(ballCount, strikeCount)
        return judge.isGameOver(strikeCount, numberSize)
    }
}