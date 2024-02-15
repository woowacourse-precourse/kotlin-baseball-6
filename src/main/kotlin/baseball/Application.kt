package baseball

import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val numberSize = 3
    while (true) {
        InputView.printGameStartMessage()

        val computer = getComputerNumbers(numberSize)

        startGameProcess(numberSize, computer)

        OutputView.printGameEndMessage(numberSize)

        if (!InputView.isReStart()) break
    }
}

private fun startGameProcess(numberSize: Int, computer: MutableList<Int>) {
    while (true) {
        var ballCount = 0
        var strikeCount = 0
        val inputNumbers = InputView.getInputNumbers()

        checkInputNumberSize(inputNumbers, numberSize)

        strikeCount = judgeStrike(numberSize, computer, inputNumbers, strikeCount)

        ballCount = judgeBall(numberSize, computer, inputNumbers, ballCount)

        OutputView.printJudgeResult(ballCount, strikeCount)

        if (isGameOver(strikeCount, numberSize)) break
    }
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

private fun getComputerNumbers(numberSize: Int): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < numberSize) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
