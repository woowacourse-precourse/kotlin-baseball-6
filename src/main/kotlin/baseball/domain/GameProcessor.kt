package baseball.domain

import baseball.view.InputView
import baseball.view.OutputView

class GameProcessor (private val numberSize: Int) {

    fun startGameProcess(): Boolean {
        val computer = Computer(numberSize)
        val judge = Judge()

        while (true) {
            val inputNumbers = InputView.getInputNumbers()

            checkInputNumberSize(inputNumbers, numberSize)

            val strikeCount = judge.judgeStrike(numberSize, computer.numbers, inputNumbers)
            val ballCount = judge.judgeBall(numberSize, computer.numbers, inputNumbers)

            OutputView.printJudgeResult(ballCount, strikeCount)

            if (judge.isGameOver(strikeCount, numberSize)) break
        }

        return !InputView.isReStart()
    }

    private fun checkInputNumberSize(inputNumbers: String, numberSize: Int) {
        if (inputNumbers.length != numberSize) {
            throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
        }
    }
}