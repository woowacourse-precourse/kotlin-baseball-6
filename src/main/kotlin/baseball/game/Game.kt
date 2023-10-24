package baseball.game

import baseball.model.Computer
import baseball.model.Player
import baseball.util.Constants.LENGTH_NUMBER
import baseball.util.Constants.NO_BALL
import baseball.util.Constants.RESTART
import baseball.util.Constants.TEXT_ALL_CORRECT
import baseball.util.Constants.TEXT_START_GAME

class Game {

    fun init() {
        println(TEXT_START_GAME)

        do {
            startGame()
        } while (restart())
    }

    private fun startGame() {
        val computer = Computer.getRandomNum()

        do {
            val player = Player.inputNumber()

            val result = GameResult(computer, player)

            result.print()

            val (ball, strike) = result.getBallAndStrike()
        } while (!isCorrect(ball, strike))

        println(TEXT_ALL_CORRECT)
    }

    private fun isCorrect(ball: Int, strike: Int): Boolean {
        return ball == NO_BALL && strike == LENGTH_NUMBER
    }

    private fun restart(): Boolean {
        return Player.askRestart() == RESTART
    }
}