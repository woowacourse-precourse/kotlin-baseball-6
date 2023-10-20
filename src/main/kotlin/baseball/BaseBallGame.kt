package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {
    companion object {
        private const val NUMBERS_LENGTH = 3
        private const val NUMBER_START_RANGE = 1
        private const val NUMBER_END_RANGE = 9
        private const val GAME_END_USER_ANSWER = 2

        private const val PROGRAM_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val INPUT_USER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : "
        private const val INPUT_USER_ANSWER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

        private const val NOTING_MESSAGE = "낫싱"
        private const val BALL_MESSAGE = "볼"
        private const val STRIKE_MESSAGE = "스트라이크"
        private const val ANSWER_HINT_MESSAGE = "3스트라이크"

        private const val USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE = "1 또는 2를 입력해야 합니다."
        private const val USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE = "3개의 숫자를 입력해야 합니다."
        private const val USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE = "중복된 숫자를 입력할 수 없습니다."
    }

    fun startGame() {
        println(PROGRAM_START_MESSAGE)
        do {
            playRound()
        } while(getUserAnswer() != GAME_END_USER_ANSWER)
    }

    private fun playRound() {
        val computerNumbers = generateRandomNumbers()
        do {
            val userNumbers = getUserNumbers()
            val result = compareNumbers(computerNumbers, userNumbers)
            val hintMessage = provideHintMessage(result)
            println(hintMessage)
        } while (hintMessage != ANSWER_HINT_MESSAGE)
        println(GAME_END_MESSAGE)
    }

    fun generateRandomNumbers(): List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < NUMBERS_LENGTH) {
            val number = Randoms.pickNumberInRange(NUMBER_START_RANGE, NUMBER_END_RANGE)
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
        return randomNumbers
    }

    private fun getUserNumbers() : List<Int> {
        print(INPUT_USER_NUMBERS_MESSAGE)
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

    fun validateUserNumbers(userInput: String) {
        if (!userInput.all { it.isDigit() }) {
            throw IllegalArgumentException(USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE)
        }
        if (userInput.length != NUMBERS_LENGTH) {
            throw IllegalArgumentException(USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE)
        }
        if (userInput.toSet().size != NUMBERS_LENGTH) {
            throw IllegalArgumentException(USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE)
        }
    }

    private fun getUserAnswer() : Int {
        println(INPUT_USER_ANSWER_MESSAGE)
        val userInput = readUserInput()
        validateUserAnswer(userInput)

        return userInput.toInt()
    }

    fun validateUserAnswer(userInput: String) {
        if (!(userInput == "1" || userInput == "2")) {
            throw IllegalArgumentException(USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE)
        }
    }

    fun compareNumbers(computerNumbers: List<Int>, userNumbers: List<Int>) : List<Int> {
        var ball = 0
        var strike = 0

        for (i in userNumbers.indices) {
            if (userNumbers[i] == computerNumbers[i]) {
                strike++
            } else if (userNumbers[i] in computerNumbers) {
                ball++
            }
        }
        return listOf(ball,strike)
    }

    fun provideHintMessage(result: List<Int>) : String {
        val ball = result[0]
        val strike = result[1]
        var resultMessage = ""

        if (ball + strike == 0) {
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
}