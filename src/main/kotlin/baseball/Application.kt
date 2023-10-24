package baseball

import game.BaseballGame
import user.User

fun main() {
    playBaseballGame()
}

private fun playBaseballGame() {
    val user = User()
    val baseballGame = BaseballGame(user)

    while (true) {
        user.apply {
            printInputMessage()
            inputBaseballNumber()
        }
        with(baseballGame) {
            printBaseballResultMessage()
            if(isThreeStrikes()) {
                printBaseballGameSuccessMessage()
                if(user.inputRestartOrExit() != User.EXIT) setNewRandomNumbers() else return
            }
        }
    }
}
