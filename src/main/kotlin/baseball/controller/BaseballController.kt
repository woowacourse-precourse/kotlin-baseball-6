package baseball.controller

import baseball.model.BaseballGameStatus
import baseball.model.BaseballGameStatus.GAME_END
import baseball.model.BaseballGameStatus.GAME_START
import baseball.model.BaseballGameStatus.GAME_PLAYING
import baseball.model.BaseballGameStatus.GAME_RESTART
import baseball.model.BaseballModel
import baseball.view.BaseballView
import camp.nextstep.edu.missionutils.Console

class BaseballController() {

    fun playGame() {
        var answerNumber = ""
        BaseballView().printStartGameMessage()
        var gameStatus = GAME_START
        while (true) {
            when (gameStatus) {
                GAME_START -> {
                    answerNumber = BaseballModel().createRandomNumber()
                    gameStatus = GAME_PLAYING
                }

                GAME_PLAYING -> {
                    gameStatus = gamePlaying(answerNumber, gameStatus)
                }

                GAME_RESTART -> {
                    gameStatus = gameRestart()
                }

                GAME_END -> {
                    break
                }
            }
        }
    }

    private fun gameRestart(): BaseballGameStatus {
        val inputRestart = Console.readLine()
        return when (inputRestart) {
            "1" -> GAME_START
            "2" -> GAME_END
            else -> {
                callException()
            }
        }
    }
    private fun gamePlaying(answerNumber: String, gameStatus: BaseballGameStatus): BaseballGameStatus {
        BaseballView().printInputNumberMessage()
        val userNumber = inputNumber()
        val hint = BaseballModel().calculateHint(answerNumber, userNumber)
        BaseballView().printHintMessage(hint)
        if (hint.strikes == 3) {
            BaseballView().printEndGameMessage()
            BaseballView().printRestartGameMessage()
            return GAME_RESTART
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

    private fun callException(): Nothing = throw IllegalArgumentException("잘못된 값을 입력하였습니다.")

    fun checkLength(inputNumber: String) {
        if (inputNumber.length != 3) {
            callException()
        }
    }

    fun checkDifferentNumber(inputNumber: String) {
        if (inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
            callException()
        }
    }

    fun checkIsDigit(inputNumber: String) {
        inputNumber.forEach {
            if (49 > it.code || 57 < it.code) callException()
        }
    }
}