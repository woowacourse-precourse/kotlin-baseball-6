package baseball.controller

import baseball.BASEBALL_MAX_SIZE
import baseball.model.BaseBall
import baseball.model.Computer
import baseball.model.User
import baseball.view.BaseBallView
import camp.nextstep.edu.missionutils.Console

class BaseBallController {

    private val baseBallView = BaseBallView()

    fun playGame() {
        baseBallView.printPlayGame()
        val computer = Computer()
        var computerBaseBall = BaseBall(mutableListOf())
        var status = START

        while (true) {
            when (status) {
                START -> {
                    computerBaseBall = computer.makeComputerList()
                    status = CONTINUE
                }

                CONTINUE -> {
                    baseBallView.printInputUser()
                    val user = User().inputUser()
                    status = checkAnswer(computerBaseBall, user)
                }

                END -> {
                    break
                }
            }
        }

    }

    private fun checkAnswer(computerList: BaseBall, userList: BaseBall): Int {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        baseBallView.printBaseBallResult(strike, ball)
        if (strike == BASEBALL_MAX_SIZE) {
            baseBallView.printGameOver()
            return askContinueGame()
        }

        return CONTINUE
    }

    private fun checkStrike(computerList: BaseBall, userList: BaseBall): Int {
        var strike = 0
        for (i in 0 until userList.baseBallData.size) {
            if (userList.baseBallData[i] == computerList.baseBallData[i]) {
                strike++
            }
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

    private fun askContinueGame(): Int {
        baseBallView.printContinue()
        val input = Console.readLine()

        require(input == GAME_END_NUM || input == GAME_CONTINUE_NUM)

        if (input == GAME_END_NUM) {
            return END
        }
        return START
    }

    companion object {
        const val GAME_END_NUM = "2"
        const val GAME_CONTINUE_NUM = "1"

        const val END = 1
        const val START = 2
        const val CONTINUE = 3
    }
}