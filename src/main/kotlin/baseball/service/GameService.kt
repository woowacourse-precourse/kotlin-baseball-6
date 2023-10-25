package baseball.service

import baseball.domain.Computer
import baseball.domain.GameLogic
import baseball.view.ResultView

class GameService(private val computer: Computer, private val resultView: ResultView) {
    fun startGame(userInput: Int): Boolean {
        val gameLogic = GameLogic(computer.computerNum, userInput)
        val gameResult = gameLogic.checkResult()

        resultView.printResultView(gameLogic, gameResult.first, gameResult.second)

        return gameResult.first == 3
    }

    fun restartGame() {
        computer.updateNumber()
    }
}