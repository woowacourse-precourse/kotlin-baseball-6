package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameProgram {
    fun startProgram() {
        println(PROGRAM_START_MESSAGE)

        do {
            playGame()
            println(INPUT_USER_ANSWER_MESSAGE)
            val userAnswer = setUserAnswer()
        } while(userAnswer != GAME_END_USER_ANSWER)
    }

    private fun playGame() {
        val computerNumbers = createRandomNumbers()

        do {
            print(INPUT_USER_NUMBERS_MESSAGE)
            val userNumbers = setUserNumbers()
            val result = compareNumbers(computerNumbers, userNumbers)
            val hintMessage = provideHintMessage(result)
            println(hintMessage)
        } while (hintMessage != ANSWER_HINT_MESSAGE)
        println(GAME_END_MESSAGE)
    }

    private fun createRandomNumbers(): List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < BASEBALLGAME_NUMBERS_LENGTH) {
            val number = Randoms.pickNumberInRange(NUMBERS_START_RANGE, NUMBERS_END_RANGE)
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
        return randomNumbers
    }

    private fun setUserNumbers() : List<Int> {
        val userInput = readUserInput()
        validateUserNumbers(userInput)
        val userNumbers = mutableListOf<Int>()

        for (number in userInput) {
            userNumbers.add(number.digitToInt())
        }
        return userNumbers
    }

    private fun readUserInput() : String {
        val userInput = Console.readLine()
        return userInput.trim()
    }

    private fun validateUserNumbers(userInput: String) {
        for (c in userInput.toCharArray()) {
            if (!c.isDigit()) throw IllegalArgumentException(USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE)
        }
        if (userInput.length != BASEBALLGAME_NUMBERS_LENGTH) throw IllegalArgumentException(USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE)
        if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) throw IllegalArgumentException(USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE)
    }

    private fun setUserAnswer() : Int {
        val userInput = readUserInput()
        validateUserAnswer(userInput)

        return Integer.parseInt(userInput)
    }

    private fun validateUserAnswer(userInput: String) {
        if (!(userInput == "1" || userInput == "2")) {
            throw IllegalArgumentException(USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE)
        }
    }

    private fun compareNumbers(computerNumbers: List<Int>, userNumbers: List<Int>) : List<Int> {
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

    private fun provideHintMessage(result: List<Int>) : String {
        val total = result[0]
        val ball = result[1]
        val strike = result[2]
        var resultMessage = ""

        if (total == 0) {
            resultMessage += NOTING_MESSAGE
        }
        if (ball > 0) {
            resultMessage += "$ball$BALL_MESSAGE"
        }
        if (strike > 0 && ball == 0) {
            resultMessage += "$strike$STRIKE_MESSAGE"
        }
        else if (strike > 0 && ball > 0) {
            resultMessage += " $strike$STRIKE_MESSAGE"
        }

        return resultMessage
    }

    companion object {
        private const val BASEBALLGAME_NUMBERS_LENGTH = 3
        private const val NUMBERS_START_RANGE = 1
        private const val NUMBERS_END_RANGE = 9
        private const val GAME_END_USER_ANSWER = 2

        private const val PROGRAM_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val INPUT_USER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : "
        private const val INPUT_USER_ANSWER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

        private const val NOTING_MESSAGE = "낫싱"
        private const val BALL_MESSAGE = "볼"
        private const val STRIKE_MESSAGE = "스트라이크"
        private const val ANSWER_HINT_MESSAGE = "3스트라이크"

        private const val USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE = "1 또는 2를 입력 해야 합니다."
        private const val USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE = "3개의 숫자를 입력 해야 합니다."
        private const val USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE = "중복된 숫자를 입력할 수 없습니다."
    }
}