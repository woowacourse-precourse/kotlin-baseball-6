package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameProgram {

    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
        val computerNumbers = createRandomNumbers()

        do {
            print("숫자를 입력해주세요 : ")
            val userNumbers = setUserNumbers()

            val result = compareNumbers(computerNumbers, userNumbers)
            val hintMessage = provideHintMessage(result)
            println(hintMessage)
        } while (hintMessage != "3스트라이크")
    }

    private fun createRandomNumbers():List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < 3) {
            val number = Randoms.pickNumberInRange(1,9)
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
        return randomNumbers
    }

    private fun setUserNumbers(): List<Int> {
        val userInput = readUserInput()
        validateUserInput(userInput)
        val userNumbers = mutableListOf<Int>()

        for (number in userInput) {
            userNumbers.add(number.digitToInt())
        }
        return userNumbers
    }

    private fun readUserInput():String {
        val userInput = Console.readLine()
        return userInput.trim()
    }

    private fun validateUserInput(userInput : String) {
        for (c in userInput.toCharArray()) {
            if (!c.isDigit()) throw IllegalArgumentException("숫자를 입력 해야 합니다.")
        }
        if (userInput.length != 3) throw IllegalArgumentException("3개의 숫자를 입력 해야 합니다.")
        if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) throw IllegalArgumentException("서로 중복되지 않는 숫자를 입력 해야 합니다.")
    }

    private fun provideHintMessage(result: List<Int>) : String {
        val total = result[0]
        val ball = result[1]
        val strike = result[2]
        var resultMessage = ""

        if (total == 0) {
            resultMessage += "낫씽"
        }
        if (ball > 0) {
            resultMessage += ball.toString() + "볼"
        }
        if (strike > 0 && ball == 0) {
            resultMessage += strike.toString() + "스트라이크"
        }
        else if (strike > 0 && ball > 0) {
            resultMessage += " " + strike.toString() + "스트라이크"
        }

        return resultMessage
    }

    private fun compareNumbers(computerNumbers : List<Int>,userNumbers : List<Int>): List<Int> {
        var total = 0
        var strike = 0

        for (number in userNumbers) {
            if (computerNumbers.contains(number)) {
                total++
            }
        }
        for (idx in userNumbers.indices) {
            if (computerNumbers[idx] == userNumbers[idx]) {
                strike++
            }
        }
        val ball = total - strike

        return listOf(total,ball,strike)
    }
}