package baseball.domain

import baseball.utils.Constants

class GameLogic(private val computerNum: Int, private val userNum: Int) {

    fun checkResult(): Pair<Int, Int> {
        val strikes = countStrikes(computerNum, userNum)
        val balls = countBalls(computerNum, userNum)

        return Pair(strikes, balls)
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

    fun getResultMessage(strikes: Int, balls: Int): String {
        return if (strikes == 3) {
            Constants.STRIKE_MESSAGE + "\n" + Constants.GAME_OVER_MESSAGE
        } else {
            getGameProgressMessage(strikes, balls)
        }
    }

    private fun getGameProgressMessage(strikes: Int, balls: Int): String {
        val strikeMessage = if (strikes > 0) "$strikes" + Constants.STRIKE_MESSAGE else ""
        val ballMessage = if (balls > 0) "$balls" + Constants.BALL_MESSAGE else ""

        return if (strikeMessage.isEmpty() && ballMessage.isEmpty()) {
            Constants.NOTHING_MESSAGE
        } else {
            "$ballMessage $strikeMessage".trim()
        }
    }
}