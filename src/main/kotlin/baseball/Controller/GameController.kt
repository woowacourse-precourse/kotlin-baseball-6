package baseball.Controller

import baseball.Model.BaseBall
import baseball.Model.Computer
import baseball.Util.Constants.RESTART
import baseball.View.InputView
import baseball.View.OutputView

class GameController(private val inputView: InputView, private val outputView: OutputView) {
    private val computer = Computer()
    private val baseBall = BaseBall()

    fun run() {
        gameInit()
        gameStart()
        gameEnd()
    }

    private fun gameInit() {
        outputView.printGameStart()
        computer.setComputerNumber()
    }

    private fun gameStart() {
        do {
            oneCycleGame()
        } while (baseBall.gameStatus())
    }

    private fun gameEnd() {
        outputView.printGameEndMessage()
        val status = inputView.decideGameStatus()
        if (status == RESTART) {
            gameReset()
        }
    }

    private fun gameReset() {
        computer.resetComputerNumber()
        computer.setComputerNumber()
        gameStart()
    }

    private fun makeIntList(number: String): List<Int> {
        return number.map { it.digitToInt() }.toList()
    }

    private fun oneCycleGame() {
        outputView.printInputNumberMessage()
        val input = inputView.getUserInputList()
        val userNumber = makeIntList(input)
        baseBall.compareNumber(computer.numberList, userNumber)
        outputView.printHint(baseBall)
    }
}