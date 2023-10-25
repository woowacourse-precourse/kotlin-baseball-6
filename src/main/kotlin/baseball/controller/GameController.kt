package baseball.controller

import baseball.domain.Computer
import baseball.domain.Hint
import baseball.domain.Player
import baseball.view.View

class GameController {

    init {
        println(View.GREETING)
        startGame()
    }

    private fun startGame() {
        do {
            val computer = Computer()
            val player = Player()
            answerNumbers(computer, player)
        } while (player.isRestart())
    }

    private fun answerNumbers(computer: Computer, player: Player) {
        do {
            player.getNumber()

            val hint = Hint(computer, player)
        } while (!hint.isCorrect())

        println(View.SUCCESS)
    }

}