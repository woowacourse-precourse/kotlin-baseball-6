package baseball.service

import baseball.domain.Computer
import baseball.domain.GameLogic
import baseball.view.ResultView

class GameService(private val computer: Computer, private val resultView: ResultView) {
    fun startGame(userInput: Int): Boolean {
        val gameLogic = GameLogic(computer.computerNum, userInput)
        val gameResult = gameLogic.checkResult()
        val strikes = gameResult.first
        val balls = gameResult.second

        resultView.printResultView(gameLogic, strikes, balls)

        return strikes== 3
    }

    fun restartGame() {
        computer.updateNumber()
    }
}