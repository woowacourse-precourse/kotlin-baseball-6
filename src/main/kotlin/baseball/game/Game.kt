package baseball.game

import baseball.model.Computer
import baseball.model.Player
import baseball.util.Constants.TEXT_START_GAME

class Game {

    fun init() {
        println(TEXT_START_GAME)

        startGame()
    }

    private fun startGame() {
        val computer = Computer.getRandomNum()

        val player = Player.inputNumber()
    }
}