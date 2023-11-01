package baseball.Controller

import baseball.Model.Computer
import baseball.View.InputView
import baseball.View.OutputView
import camp.nextstep.edu.missionutils.Randoms

class GameController(private val inputView: InputView, private val outputView: OutputView) {
    val computer = Computer()
    fun run() {
        outputView.printGameStart()
        computer.setComputerNumber()

        while (true) {
            val input = inputView.getUserInputList()
            val userNumber = makeIntList(input)
            val hint = compareNumber(computer.numberList, userNumber)
            outputView.printHint(hint)
            if (hint.first == 3) {
                outputView.printGameEndMessage()
                val status = inputView.decideGameStatus()
                if (status == 1) {
                    computer.resetComputerNumber()
                    computer.setComputerNumber()
                } else {
                    break
                }
            }
        }
    }

    fun makeIntList(number: String): List<Int> {
        return number.map { it.digitToInt() }.toList()
    }

    fun compareNumber(computer: List<Int>, user: List<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0

        for (i in user.indices) {
            if (computer[i] == user[i]) {
                strike++
            } else if (computer.contains(user[i])) {
                ball++
            }
        }
        return Pair(strike, ball)
    }
}