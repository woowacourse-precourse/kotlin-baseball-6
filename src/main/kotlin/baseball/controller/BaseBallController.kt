package baseball.controller

import baseball.model.BaseBall
import baseball.model.Computer
import baseball.model.User
import baseball.view.BaseBallView

class BaseBallController {

    private val baseBallView = BaseBallView()

    fun playGame() {
        baseBallView.printPlayGame()

        val computer = Computer().makeComputerList()
        baseBallView.printInputUser()
        val user = User().inputUser()
        checkBaseBall(computer, user)


    }

    private fun checkBaseBall(computerList: BaseBall, userList: BaseBall) {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        baseBallView.printBaseBallResult(strike, ball)

        if (strike == 3) {
            print("멈춰")
        }

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
}