package baseball

import baseball.util.GameState.BALL
import baseball.util.GameState.MATCHING_ALL_MESSAGE
import baseball.util.GameState.MATCHING_ZERO_MESSAGE
import baseball.util.GameState.STRIKE
import baseball.util.GameValue.GAME_COMPLETE_STRIKE
import baseball.util.GameValue.GAME_INIT_VALUE

abstract class Game {
    private var strike = GAME_INIT_VALUE
    private var ball = GAME_INIT_VALUE
    private lateinit var answer: List<Int>

    protected fun gameSetting() {
        answer = Computer.makeNumber()
    }

    protected fun resultCheck(playerNumber: List<Int>) {
        valueInit()
        getBallCount(playerNumber)
        getStrikeCount(playerNumber)
        resultPrint()
    }

    protected fun isResult(): Boolean {
        if (strike == GAME_COMPLETE_STRIKE) {
            println(MATCHING_ALL_MESSAGE)
            return true
        }
        return false
    }

    private fun getBallCount(playerNumber: List<Int>) {
        answer.forEachIndexed { index, i ->
            if (playerNumber[index] != i && playerNumber.contains(i)) {
                ballPlus()
            }
        }
    }

    private fun getStrikeCount(playerNumber: List<Int>) {
        answer.forEachIndexed { index, i ->
            if (playerNumber[index] == i) {
                strikePlus()
            }
        }
    }

    private fun resultPrint() {
        if (ball == GAME_INIT_VALUE && strike == GAME_INIT_VALUE) {
            print(MATCHING_ZERO_MESSAGE)
        }
        if (ball != GAME_INIT_VALUE) {
            print("$ball$BALL")
        }
        if (strike != GAME_INIT_VALUE) {
            print("$strike$STRIKE")
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
