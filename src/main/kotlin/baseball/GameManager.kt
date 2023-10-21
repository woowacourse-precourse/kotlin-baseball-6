package baseball

import baseball.util.GameState.GAME_RESTART_MESSAGE
import baseball.util.GameState.GAME_START_MESSAGE
import baseball.util.GameState.MATCHING_ALL_MESSAGE
import baseball.util.GameValue.GAME_COMPLETE_STRIKE
import baseball.util.GameValue.RESTART_COMMAND
import baseball.util.GameValue.STOP_COMMAND
import camp.nextstep.edu.missionutils.Console

class GameManager : Game() {

    private lateinit var computerNumber: List<Int>
    private lateinit var playerNumber: List<Int>

    fun gameMaking() {
        println(GAME_START_MESSAGE)
        do {
            computerNumber = Computer.makeNumber()
            println(computerNumber)
            gameStart()
        } while (restartQuestion())
    }

    private fun gameStart() {
        do {
            playerNumber = Player.inputNumber()
            result(playerNumber, computerNumber)
        } while (isResult())
    }

    private fun isResult(): Boolean {
        if (strike != GAME_COMPLETE_STRIKE) {
            return true
        }
        println(MATCHING_ALL_MESSAGE)
        return false
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