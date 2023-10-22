package baseball.controller

import baseball.model.BaseballGameStatus
import baseball.model.BaseballModel
import baseball.view.BaseballView
import camp.nextstep.edu.missionutils.Console

class BaseballController() {

    fun playGame() {
        var answerNumber = ""
        BaseballView().printStartGameMessage()
        var gameStatus = BaseballGameStatus.GAME_START
        while (gameStatus != BaseballGameStatus.GAME_END) {
            when (gameStatus) {
                BaseballGameStatus.GAME_START -> {
                    answerNumber = BaseballModel().createRandomNumber()
                    gameStatus = BaseballGameStatus.GAME_PLAYING
                    println(answerNumber)
                }

                BaseballGameStatus.GAME_PLAYING -> {
                    gameStatus = gamePlaying(answerNumber, gameStatus)
                }

                BaseballGameStatus.GAME_RESTART -> {

                }
            }
        }
    }

    private fun gamePlaying(answerNumber: String, gameStatus: BaseballGameStatus): BaseballGameStatus {
        BaseballView().printInputNumberMessage()
        val userNumber = inputNumber()
        val hint = BaseballModel().calculateHint(answerNumber, userNumber)
        BaseballView().printHintMessage(hint)
        if (hint.strikes == 3) {
            return BaseballGameStatus.GAME_RESTART
        }
        return gameStatus
    }

    private fun inputNumber(): String {
        val inputNumber = Console.readLine()
        checkLength(inputNumber)
        checkIsDigit(inputNumber)
        checkDifferentNumber(inputNumber)

        return inputNumber
    }

    private fun callException(): Nothing = throw IllegalArgumentException("잘못")

    private fun checkLength(inputNumber: String) {
        if (inputNumber.length != 3) {
            callException()
        }
    }

    private fun checkDifferentNumber(inputNumber: String) {
        if (inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
            callException()
        }
    }

    private fun checkIsDigit(inputNumber: String) {
        inputNumber.forEach {
            if (49 > it.code || 57 < it.code) callException()
        }
    }
}