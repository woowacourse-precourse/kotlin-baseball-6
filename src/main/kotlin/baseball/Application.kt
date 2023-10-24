package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val USER_INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val NUMBER_LENGTH = 3
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9
const val RESTART = "1"
const val END_GAME = "2"

var isAllNumberGuessed = false
var playingGame = true

fun main() {
    println(START_MESSAGE)
    while (playingGame) {
        val randomNum = createRandomNumber()
        while (!isAllNumberGuessed) {
            guessingNumber(randomNum)
        }
        askReplayGame()
    }
}

private fun createRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < NUMBER_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

private fun getUserInput(): String {
    print(USER_INPUT_MESSAGE)
    return Console.readLine()
}

private fun guessingNumber(computer: List<Int>) {
    getUserInput().let { userInput ->
        if (validateUserInput(userInput)) {
            val result = checkResult(computer, userInput)
            println(result)
        }
    }
}

private fun validateUserInput(user: String): Boolean {
    val isNumeric = user.toIntOrNull() != null
    val isCorrectLength = user.length == NUMBER_LENGTH
    val isUniqueDigits = user.toSet().size == NUMBER_LENGTH
    val isInRange = user.all { it.toString().toInt() in MIN_NUMBER..MAX_NUMBER }
    when {
        !isNumeric -> throw IllegalArgumentException(Error.NOT_NUMBERIC.errorMessage)
        !isCorrectLength -> throw IllegalArgumentException(Error.NOT_CORRECT_LENGTH.errorMessage)
        !isUniqueDigits -> throw IllegalArgumentException(Error.NOT_UNIQUE_DIGITS.errorMessage)
        !isInRange -> throw IllegalArgumentException(Error.NOT_IN_RANGE.errorMessage)
        else -> return true
    }
}

private fun checkResult(computer: List<Int>, user: String): String {
    val userInput = user.map { it.toString().toInt() }
    var strike = 0
    var ball = 0
    for (i in computer.indices) {
        if (computer[i] == userInput[i]) {
            strike++
        } else if (computer.contains(userInput[i])) {
            ball++
        }
    }
    return when {
        strike == NUMBER_LENGTH -> {
            isAllNumberGuessed = true
            "$NUMBER_LENGTH${State.STRIKE.stateName}"
        }

        strike == 0 && ball == 0 -> State.NOTHING.stateName
        else -> "${ball}${State.BALL.stateName} ${strike}${State.STRIKE.stateName}"
    }
}

private fun askReplayGame() {
    println(FINISH_MESSAGE)
    when (Console.readLine()) {
        RESTART -> isAllNumberGuessed = false
        END_GAME -> playingGame = false
        else -> throw IllegalArgumentException(Error.COMMON.errorMessage)
    }
}

enum class Error(val errorMessage: String) {
    NOT_NUMBERIC("숫자를 입력해주세요."),
    NOT_CORRECT_LENGTH("${NUMBER_LENGTH}자리 수를 입력해주세요"),
    NOT_UNIQUE_DIGITS("각 자리의 숫자는 서로 달라야합니다."),
    NOT_IN_RANGE("${MIN_NUMBER}에서 $MAX_NUMBER 사이의 숫자를 입력해주세요."),
    COMMON("잘못된 입력입니다.")
}

enum class State(val stateName: String) {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱")
}