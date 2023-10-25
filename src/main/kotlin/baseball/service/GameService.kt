package baseball.service

import baseball.domain.Computer
import baseball.domain.GameLogic
import baseball.view.ResultView

class GameService(private val computer: Computer) {
    fun startGame(userInput: Int): Boolean {
        val gameLogic = GameLogic(computer.computerNum, userInput)

        return gameLogic.checkResult(ResultView())
    }

    fun restartGame() {
        computer.updateNumber()
    }
}