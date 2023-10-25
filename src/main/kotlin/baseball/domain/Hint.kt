package baseball.domain

import baseball.view.View

private const val NUMLIST_SIZE = 3
private const val NUM_ZERO = 0

class Hint(
    computer: Computer,
    player: Player
) {
    private var strike = 0
    private var ball = 0

    init {
        strike = countStrike(computer.numList, player.numList)
        ball = countBall(computer.numList, player.numList)
        printHint()
    }

    private fun countStrike(
        computer: MutableList<Int>,
        player: MutableList<Int>
    ): Int {
        for (index in NUM_ZERO until NUMLIST_SIZE) {
            if (computer[index] == player[index]) {
                strike++
            }
        }
        return strike
    }

    private fun countBall(
        computer: MutableList<Int>,
        player: MutableList<Int>
    ): Int {
        for (index in NUM_ZERO until NUMLIST_SIZE) {
            if (computer[index] != player[index] && player.contains(computer[index])) {
                ball++
            }
        }
        return ball
    }

    private fun printHint() {
        when {
            ball == NUM_ZERO && strike == NUM_ZERO -> {
                println(View.NOTHING)
            }

            ball == NUM_ZERO && strike != NUM_ZERO -> {
                println("${strike}${View.STRIKE}")
            }

            ball != NUM_ZERO && strike == NUM_ZERO -> {
                println("${ball}${View.BALL}")
            }

            else -> {
                println("${ball}${View.BALL} ${strike}${View.STRIKE}")
            }
        }
    }

    fun isCorrect(): Boolean {
        if (strike == NUMLIST_SIZE) {
            return true
        }
        return false
    }
}