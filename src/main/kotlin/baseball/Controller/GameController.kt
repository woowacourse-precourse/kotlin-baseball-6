package baseball.Controller

import baseball.Model.BaseBall
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
            val baseBall = BaseBall()
            baseBall.compareNumber(computer.numberList, userNumber)
            outputView.printHint(baseBall)
            if (baseBall.isGameEnd()) {
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
}