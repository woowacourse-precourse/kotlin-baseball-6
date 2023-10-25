package baseball.controller

import baseball.BASEBALL_MAX_SIZE
import baseball.model.BaseBall
import baseball.model.Computer
import baseball.model.User
import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class BaseBallController {

    private val inputVIew = InputView()
    private val outputVIew = OutputView()
    private var status = START

    fun playGame() {
        inputVIew.printPlayGame()
        val computer = Computer()
        var computerBaseBall = BaseBall(mutableListOf())

        while (true) {
            when (status) {
                START -> {
                    computerBaseBall = startGame(computer)
                }

                CONTINUE -> {
                    continueGame(computerBaseBall)
                }

                END -> {
                    break
                }
            }
        }
    }

    private fun startGame(computer: Computer): BaseBall {
        status = CONTINUE
        return computer.makeComputerList()
    }

    private fun continueGame(computerBaseBall: BaseBall) {
        inputVIew.printInputUser()
        val user = User().inputUser()
        status = checkAnswer(computerBaseBall, user)
    }

    private fun checkAnswer(computerList: BaseBall, userList: BaseBall): Int {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        outputVIew.printBaseBallResult(strike, ball)
        if (strike == BASEBALL_MAX_SIZE) {
            outputVIew.printGameOver()
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
        inputVIew.printContinue()
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