package baseball.domain

import baseball.utils.Constants
import baseball.view.ResultView

class GameLogic(private val computerNum: Int, private val userNum: Int) {

    fun checkResult(resultView: ResultView): Boolean {

        val strikes = countStrikes(computerNum, userNum)
        val balls = countBalls(computerNum, userNum)

        return if (strikes == 3) {
            println(Constants.THREE_STRIKE_MESSAGE)
            println(Constants.GAME_OVER_MESSAGE)
            true
        } else {
            resultView.printResultCount(strikes, balls)
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