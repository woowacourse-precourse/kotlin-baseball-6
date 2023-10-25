package baseball.service

import baseball.domain.Computer
import baseball.domain.GameLogic

class GameService(private val computer: Computer) {
    fun startGame(userInput: Int): Boolean {
        val gameLogic = GameLogic(computer.computerNum, userInput)

        return gameLogic.checkResult()
    }

    fun restart() {
        computer.updateNumber()
    }
}