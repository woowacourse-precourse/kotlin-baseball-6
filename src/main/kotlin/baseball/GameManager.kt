package baseball

import baseball.util.GameState.GAME_RESTART_MESSAGE
import baseball.util.GameState.GAME_START_MESSAGE
import baseball.util.GameState.MATCHING_ALL_MESSAGE
import baseball.util.GameValue.GAME_COMPLETE_STRIKE
import baseball.util.GameValue.RESTART_COMMAND
import baseball.util.GameValue.STOP_COMMAND
import camp.nextstep.edu.missionutils.Console

class GameManager : Game() {

    fun gameMaking() {
        println(GAME_START_MESSAGE)
        do {
            setGameResult()
            gameStart()
        } while (restartQuestion())
    }

    private fun gameStart() {
        do {
            resultCheck(Player.inputNumber())
        } while (isFinish())
    }

    private fun isFinish(): Boolean {
        if (strike == GAME_COMPLETE_STRIKE) {
            println(MATCHING_ALL_MESSAGE)
            return false
        }
        return true
    }

    private fun restartQuestion(): Boolean {
        println(GAME_RESTART_MESSAGE)
        val playerCommend = Console.readLine()
        if (playerCommend != RESTART_COMMAND && playerCommend != STOP_COMMAND) {
            throw IllegalArgumentException()
        }
        return playerCommend == RESTART_COMMAND
    }
}
