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
            baseballNumberInput()
        }
        with(baseballGame) {
            printBaseballResultMessage()
            if(isThreeStrikes()) {
                printBaseballGameSuccessMessage()
                if(user.restartOrExitInput() != User.EXIT) setNewRandomNumbers() else return
            }
        }
    }
}
