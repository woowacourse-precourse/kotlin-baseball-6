package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {
    companion object Constants {
        private const val NUMBERS_LENGTH = 3
        private const val NUMBER_START_RANGE = 1
        private const val NUMBER_END_RANGE = 9
        private const val RESTART_GAME_USER_ANSWER = 1

        private const val PROGRAM_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val INPUT_USER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : "
        private const val INPUT_USER_ANSWER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val GAME_END_MESSAGE = "${NUMBERS_LENGTH}개의 숫자를 모두 맞히셨습니다! 게임 종료"

        private const val NOTHING_MESSAGE = "낫싱"
        private const val BALL_MESSAGE = "볼"
        private const val STRIKE_MESSAGE = "스트라이크"
        private const val ANSWER_HINT_MESSAGE = "3스트라이크"
    }

    fun startGame() {
        println(PROGRAM_START_MESSAGE)
        do {
            playRound()
        } while (getUserAnswer() == RESTART_GAME_USER_ANSWER)
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
        val randomNumbers = mutableSetOf<Int>()

        while (randomNumbers.size < NUMBERS_LENGTH) {
            val number = Randoms.pickNumberInRange(NUMBER_START_RANGE, NUMBER_END_RANGE)
            randomNumbers.add(number)
        }
        return randomNumbers.toList()
    }

    private fun readUserInput(): String {
        val userInput = Console.readLine()
        return userInput.trim()
    }

    private fun getUserNumbers(): List<Int> {
        print(INPUT_USER_NUMBERS_MESSAGE)
        val userInput = readUserInput()
        validateUserNumbers(userInput)
        return userInput.map { it.toString().toInt() }
    }

    private fun getUserAnswer(): Int {
        println(INPUT_USER_ANSWER_MESSAGE)
        val userInput = readUserInput()
        validateUserAnswer(userInput)

        return userInput.toInt()
    }

    fun compareNumbers(computerNumbers: List<Int>, userNumbers: List<Int>): Pair<Int, Int> {
        val total = userNumbers.count { computerNumbers.contains(it) }
        val strike = userNumbers.count { userNumbers.indexOf(it) == computerNumbers.indexOf((it)) }
        val ball = total - strike;

        return Pair(ball, strike)
    }

    fun provideHintMessage(result: Pair<Int, Int>): String {
        val ball = result.first
        val strike = result.second
        val resultMessage = mutableListOf<String>()

        if (ball == 0 && strike == 0) {
            resultMessage.add(NOTHING_MESSAGE)
        }
        if (ball > 0) {
            resultMessage.add("$ball$BALL_MESSAGE")
        }
        if (strike > 0) {
            resultMessage.add("$strike$STRIKE_MESSAGE")
        }
        return resultMessage.joinToString(" ")
    }
}