package baseball

import game.BaseballGame
import user.User

fun main() {
    startBaseballGame()
}

private fun startBaseballGame() {
    val user = User()
    val baseballGame = BaseballGame(user)

    while (true) {
        user.apply {
            printInputMessage()
            baseballNumberInput()
        }
        with(baseballGame) {
            if(isBaseballGameResult()) {
                printBaseballGameSuccess()
                if(user.restartOrExitInput() != User.EXIT) setNewRandomNumbers() else return
            }
        }
    }
}
