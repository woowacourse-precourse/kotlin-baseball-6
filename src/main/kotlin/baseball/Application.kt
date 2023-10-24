package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import util.Constants.DUPLICATE_NUMBER_MESSAGE
import util.Constants.INPUT_MESSAGE
import util.Constants.INVALID_INPUT_MESSAGE
import util.Constants.INVALID_LENGTH_MESSAGE
import util.Constants.RESTART_MESSAGE
import util.Constants.START_MESSAGE
import util.Constants.SUCCESS_MESSAGE

fun main() {
    println(START_MESSAGE)
    do {
        startBaseballGame()
    } while (isRestartable())
}

fun startBaseballGame() {
    val answerNumbers = creatRandomNumbers()
//    println(answerNumbers) // 랜덤 생성된 정답 미리보기
    do {
        val userNumbers = getUserInput()
        printScore(answerNumbers, userNumbers)
    } while (!isSame(answerNumbers, userNumbers))
    println(SUCCESS_MESSAGE)
}

fun isSame(answer: List<Int>, user: List<Int>) = answer == user


fun creatRandomNumbers(): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) numbers.add(randomNumber)
    }
    return numbers
}

fun getUserInput(): MutableList<Int> {
    print(INPUT_MESSAGE)
    val userInput = Console.readLine()
    isUserInputValid(userInput)
    var userNumber = userInput.toInt()
    val userNumberList = mutableListOf<Int>()
    repeat(3) {
        userNumberList.add(0, userNumber % 10)
        userNumber /= 10
    }
    return userNumberList
}

fun isRestartable(): Boolean {
    println(RESTART_MESSAGE)
    val restartChar = Console.readLine()
    return ("1" == restartChar)
}

fun printScore(answerNumbers: List<Int>, userNumbers: List<Int>) {
    var strikeCount = 0
    var ballCount = 0
    for (i in answerNumbers.indices) {
        if (userNumbers[i] == answerNumbers[i]) strikeCount++
        else if (answerNumbers.contains(userNumbers[i])) ballCount++
    }
    val strikeMessage = if (0 < strikeCount) "${strikeCount}스트라이크" else ""
    val ballMessage = if (0 < ballCount) "${ballCount}볼 " else ""
    val scoreMessage = if (strikeCount == 0 && ballCount == 0) "낫싱" else "$ballMessage$strikeMessage"
    println(scoreMessage)
}

fun isUserInputValid(userInput: String) {
    if (!userInput.all { it.isDigit() }) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
    if (userInput.length != 3) throw IllegalArgumentException(INVALID_LENGTH_MESSAGE)
    if (userInput.toSet().size != userInput.length) throw IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE)
}