package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val numberSize = 3
    while (true) {
        printGameStartMessage()

        val computer = getComputerNumbers(numberSize)

        startGameProcess(numberSize, computer)

        printGameEndMessage(numberSize)

        if (!isReStart()) break
    }
}

private fun printGameStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

private fun printGameEndMessage(numberSize: Int) {
    println("${numberSize}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

private fun isReStart(): Boolean {
    return Console.readLine().toInt() == 1
}

private fun startGameProcess(numberSize: Int, computer: MutableList<Int>) {
    while (true) {
        var ballCount = 0
        var strikeCount = 0
        val inputNumbers = getInputNumbers()

        checkInputNumberSize(inputNumbers, numberSize)

        strikeCount = judgeStrike(numberSize, computer, inputNumbers, strikeCount)

        ballCount = judgeBall(numberSize, computer, inputNumbers, ballCount)

        printJudgeResult(ballCount, strikeCount)

        if (isGameOver(strikeCount, numberSize)) break
    }
}

private fun isGameOver(strikeCount: Int, numberSize: Int): Boolean {
    return strikeCount == numberSize
}

private fun printJudgeResult(ballCount: Int, strikeCount: Int) {
    if (ballCount > 0) {
        print("${ballCount}볼 ")
    }

    if (strikeCount > 0) {
        print("${strikeCount}스트라이크 ")
    }

    if (ballCount == 0 && strikeCount == 0) {
        print("낫싱")
    }

    println()
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

private fun getInputNumbers(): String {
    print("숫자를 입력해주세요 : ")
    return Console.readLine()
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
