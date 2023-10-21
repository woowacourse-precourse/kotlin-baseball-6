package baseball

import baseball.util.GameState.BALL
import baseball.util.GameState.MATCHING_ZERO_MESSAGE
import baseball.util.GameState.STRIKE
import baseball.util.GameValue.GAME_INIT_VALUE

abstract class Game {
    protected var strike = GAME_INIT_VALUE
    private var ball = GAME_INIT_VALUE

    fun result(playerNumber: List<Int>, computerNumber: List<Int>) {
        valueInit()
        computerNumber.forEachIndexed { index, i ->
            playerNumber.forEachIndexed { playerIndex, num ->
                if (index != playerIndex && i == num) ballPlus()
                if (index == playerIndex && i == num) strikePlus()
            }
        }
        resultPrint()
    }

    private fun resultPrint() {
        if (ball == GAME_INIT_VALUE && strike == GAME_INIT_VALUE){
            print(MATCHING_ZERO_MESSAGE)
        }
        if (ball != GAME_INIT_VALUE) {
            print("${ball}$BALL ")
        }
        if (strike != GAME_INIT_VALUE) {
            print("${strike}$STRIKE")
        }
        println()
    }

    private fun valueInit() {
        strike = GAME_INIT_VALUE
        ball = GAME_INIT_VALUE
    }

    private fun strikePlus() = strike++

    private fun ballPlus() = ball++
}