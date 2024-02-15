package baseball.domain

import baseball.view.InputView
import baseball.view.OutputView

class GameProcessor (private val numberSize: Int) {

    fun startGameProcess(): Boolean {
        val computer = Computer(numberSize)

        while (true) {
            var ballCount = 0
            var strikeCount = 0
            val inputNumbers = InputView.getInputNumbers()

            checkInputNumberSize(inputNumbers, numberSize)

            strikeCount = judgeStrike(numberSize, computer.numbers, inputNumbers, strikeCount)

            ballCount = judgeBall(numberSize, computer.numbers, inputNumbers, ballCount)

            OutputView.printJudgeResult(ballCount, strikeCount)

            if (isGameOver(strikeCount, numberSize)) break
        }

        return !InputView.isReStart()
    }

    private fun isGameOver(strikeCount: Int, numberSize: Int): Boolean {
        return strikeCount == numberSize
    }

    private fun judgeBall(
        numberSize: Int,
        computer: MutableList<Int>,
        inputNumbers: String,
        ballCount: Int
    ): Int {
        var ballCount1 = ballCount
        for (i in 0 until numberSize) {
            if (computer.contains(inputNumbers[i].toString().toInt())) {
                if (computer[i] != inputNumbers[i].toString().toInt()) {
                    ballCount1++
                }
            }
        }
        return ballCount1
    }

    private fun judgeStrike(
        numberSize: Int,
        computer: MutableList<Int>,
        inputNumbers: String,
        strikeCount: Int
    ): Int {
        var strikeCount1 = strikeCount
        for (i in 0 until numberSize) {
            if (computer[i] == inputNumbers[i].toString().toInt()) {
                strikeCount1++
            }
        }
        return strikeCount1
    }

    private fun checkInputNumberSize(inputNumbers: String, numberSize: Int) {
        if (inputNumbers.length != numberSize) {
            throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
        }
    }
}