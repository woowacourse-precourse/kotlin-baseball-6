package baseball.controller

import baseball.model.BaseBall
import baseball.model.Computer
import baseball.model.User
import baseball.view.BaseBallView
import camp.nextstep.edu.missionutils.Console

class BaseBallController {

    private val baseBallView = BaseBallView()

    fun playGame() {
        baseBallView.printPlayGame()
        while (true) {
            val computer = Computer().makeComputerList()
            baseBallView.printInputUser()
            val user = User().inputUser()
            if (checkBaseBall(computer, user)) break
        }

    }

    private fun checkBaseBall(computerList: BaseBall, userList: BaseBall): Boolean {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        baseBallView.printBaseBallResult(strike, ball)
        if (strike == 3) {
            baseBallView.printGameOver()
            return checkContinue()
        }

        return false
    }

    private fun checkStrike(computerList: BaseBall, userList: BaseBall): Int {
        var strike = 0
        for (i in 0 until userList.baseBallData.size) {
            if (userList.baseBallData[i] == computerList.baseBallData[i])
                strike++
        }
        return strike
    }

    private fun checkBall(computerList: BaseBall, userList: BaseBall): Int {
        var ball = 0
        userList.baseBallData.forEach {
            if (computerList.baseBallData.contains(it))
                ball++
        }
        return ball
    }

    private fun checkContinue(): Boolean {
        baseBallView.printContinue()
        val input = Console.readLine()
        if (input == GAME_END_NUM) {
            return true
        }
        return false
    }

    companion object {
        const val GAME_END_NUM = "2"
    }
}