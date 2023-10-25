package baseball.domain

import baseball.utils.Constants

class GameLogic(private val computerNum: Int, private val userNum: Int) {

    fun checkResult(): Boolean {

        val strikes = countStrikes(computerNum, userNum)
        val balls = countBalls(computerNum, userNum)

        return when (strikes) {

            3 -> {
                threeStrike()
                true
            }

            else -> {
                checkZeroCount(strikes, balls)
                false
            }
        }
    }

    private fun countStrikes(computer: Int, user: Int): Int {
        var strikes = 0
        for (i in computer.toString().indices) {
            if (computer.toString()[i] == user.toString()[i]) strikes++
        }
        return strikes
    }

    private fun countBalls(computer: Int, user: Int): Int {
        var balls = 0
        for (digit in user.toString()) {
            if (digit in computer.toString()) balls++
        }
        return balls - countStrikes(computer, user)
    }

    private fun threeStrike() {
        println(Constants.THREE_STRIKE)
        println(Constants.GAME_OVER_MESSAGE)
    }

    private fun checkZeroCount(strikes: Int, balls: Int) {
        when (balls) {
            0 -> when (strikes) {
                0 -> println(Constants.NOTHING_MESSAGE)
                else -> println("$strikes"+Constants.STRIKE_MESSAGE)
            }

            else -> when (strikes) {
                0 -> println("$balls"+Constants.BALL_MESSAGE)
                else -> println("$balls"+Constants.BALL_MESSAGE + " $strikes" + Constants.STRIKE_MESSAGE)
            }
        }
    }
}