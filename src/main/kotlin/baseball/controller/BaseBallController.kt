package baseball.controller

import baseball.BASEBALL_MAX_SIZE
import baseball.model.Computer
import baseball.model.GameStatus
import baseball.model.User
import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class BaseBallController {

    private val inputVIew = InputView()
    private val outputVIew = OutputView()
    private var status = GameStatus.START

    fun playGame() {
        inputVIew.printPlayGame()
        var computerBaseBall = mutableListOf<Int>()

        while (true) {
            when (status) {
                GameStatus.START -> {
                    computerBaseBall = startGame()
                }

                GameStatus.CONTINUE -> {
                    continueGame(computerBaseBall)
                }

                GameStatus.END -> {
                    break
                }
            }
        }
    }

    private fun startGame(): MutableList<Int> {
        status = GameStatus.CONTINUE
        return Computer.makeComputerList()
    }

    private fun continueGame(computerBaseBall: MutableList<Int>) {
        inputVIew.printInputUser()
        val user = User().inputUser()
        status = checkAnswer(computerBaseBall, user)
    }

    private fun checkAnswer(computerList: MutableList<Int>, userList: MutableList<Int>): GameStatus {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList, strike)

        outputVIew.printBaseBallResult(strike, ball)
        if (strike == BASEBALL_MAX_SIZE) {
            outputVIew.printGameOver()
            return askContinueGame()
        }

        return GameStatus.CONTINUE
    }

    private fun checkStrike(computerList: MutableList<Int>, userList: MutableList<Int>): Int {
        var strike = 0
        for (i in 0 until userList.size) {
            if (userList[i] == computerList[i]) {
                strike++
            }
        }
        return strike
    }

    private fun checkBall(computerList: MutableList<Int>, userList: MutableList<Int>, strike: Int): Int {
        var ball = 0
        userList.forEach {
            if (computerList.contains(it)) {
                ball++
            }
        }
        return ball - strike
    }

    private fun askContinueGame(): GameStatus {
        inputVIew.printContinue()
        val input = Console.readLine()

        require(input == GAME_END_NUM || input == GAME_CONTINUE_NUM)

        if (input == GAME_END_NUM) {
            return GameStatus.END
        }
        return GameStatus.START
    }

    companion object {
        const val GAME_END_NUM = "2"
        const val GAME_CONTINUE_NUM = "1"
    }
}