package baseball

import baseball.util.GameState.GAME_START_MESSAGE

class GameManager : Game() {

    fun gameMaking() {
        println(GAME_START_MESSAGE)
        do {
            gameSetting()
            gameStart()
        } while (Player.restartQuestion())
    }

    private fun gameStart() {
        do {
            resultCheck(Player.inputNumber())
        } while (!isResult())
    }
}
