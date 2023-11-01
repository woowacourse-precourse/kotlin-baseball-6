package baseball

import baseball.Util.Validator.validateInteger
import baseball.Util.Validator.validateLength
import baseball.Util.Validator.validateRange
import baseball.Util.Validator.validateUniqueNumber
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printGameStart()
    val computerNumber = setComputerNumber()

    while (true) {
        val userNumber = getUserInputList()
        val hint = compareNumber(computerNumber, userNumber)
        printHint(hint)
        if (hint.first == 3) {
            break
        }
    }
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): String {
    return Console.readLine()
}

fun setComputerNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toList()
}

fun makeIntList(number: String): List<Int> {
    return number.map { it.digitToInt() }.toList()
}

fun getUserInputList(): List<Int> {
    val userInput = getUserInput()
    validateLength(userInput)
    validateInteger(userInput)
    validateRange(userInput)
    validateUniqueNumber(userInput)
    return makeIntList(userInput)
}

fun compareNumber(computer: List<Int>, user: List<Int>): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (i in user.indices) {
        if (computer[i] == user[i]) {
            strike++
        } else if (computer.contains(user[i])) {
            ball++
        }
    }
    return Pair(strike, ball)
}

fun printHint(hint: Pair<Int, Int>) {
    val (strike, ball) = hint
    val result = when {
        strike == 0 && ball == 0 -> "낫싱"
        strike > 0 && ball == 0 -> "${strike}스트라이크"
        strike == 0 && ball > 0 -> "${ball}볼"
        else -> "${ball}볼 ${strike}스트라이크"
    }

    print(result)
}
