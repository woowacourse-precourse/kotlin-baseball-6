package controller

import camp.nextstep.edu.missionutils.Console
import model.RandomNumberCreate
import validation.UserInputValidation
import view.BaseballInputView
import util.BaseballGameStatus

class BaseballGameController {
    private var computerNumber: String = ""
    private var userNumber: String = ""
    var gameStatus = BaseballGameStatus()
    var reStrat: String = ""

    public fun GameStart() {
        BaseballInputView().printStartGameMessage()
        computerNumber = RandomNumberCreate().createRandomNumber()
        while (!gameStatus.isGameStatus) {
            UserNumber()
            gameStatusReset()
            countBallStrike()
            printGameStatus()
        }
        restartGame()
    }

    private fun UserNumber() {
        BaseballInputView().printInputNumberMessage()
        userNumber = Console.readLine()
        UserInputValidation().inputLength(userNumber)
        UserInputValidation().inputZeroToNine(userNumber)
        UserInputValidation().inputUnique(userNumber)
    }

    private fun gameStatusReset() {
        gameStatus.strike = 0
        gameStatus.ball = 0
    }

    private fun countBallStrike() {
        for (i in computerNumber.indices) {
            if (computerNumber[i] == userNumber[i]) {
                gameStatus.strike++
            } else if (userNumber[i] in computerNumber) {
                gameStatus.ball++
            }
        }
        if (gameStatus.strike == 3) {
            gameStatus.isGameStatus = true
        }
    }

    private fun printGameStatus() {
        if (gameStatus.strike == 3) {
            println("3스트라이크")
            BaseballInputView().printEndGameMessage()
        } else if (gameStatus.strike == 0 && gameStatus.ball != 0) {
            println(gameStatus.ball.toString() + "볼")
        } else if (gameStatus.ball == 0 && gameStatus.strike != 0) {
            println(gameStatus.strike.toString() + "스트라이크")
        } else if (gameStatus.ball != 0 && gameStatus.strike != 0) {
            println(gameStatus.ball.toString() + "볼 " + gameStatus.strike + "스트라이크")
        } else {
            println(gameStatus.nothing)
        }
    }

    private fun restartGame() {
        BaseballInputView().printRestartGameMessage()
        reStrat = Console.readLine()
        if (reStrat.equals("1")) {
            gameStatus.isGameStatus = false
            GameStart()
        }
    }
}