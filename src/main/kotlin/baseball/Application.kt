package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

const val START = 1
const val END = 9
const val LENGTH = 3

fun main() {
    startBaseballGame()
}

private fun startBaseballGame() {
    printGameStart()
    while (true) {
        val computerNumber = pickComputerRandomNumber()
        playBaseballGame(computerNumber)
        try {
            if (!isRestart()) {
                break
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            throw e
        }
    }
    return
}

private fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

private fun pickComputerRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(START, END)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

private fun playBaseballGame(computerNumber: MutableList<Int>) {
    while (true) {
        val userNumber = inputUserNumber()
        calculateUserScore(computerNumber, userNumber)
        if (computerNumber == userNumber) {
            break
        }
    }
}

private fun inputUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val userNumber = readLine().map { it.toString().toInt() }
    return checkUserNumber(userNumber)
}

private fun checkUserNumber(userNumber: List<Int>): List<Int> {
    try {
        checkUserNumberLength(userNumber)
        checkUserNumberValidate(userNumber)
        return userNumber
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
        throw e
    }
}

private fun checkUserNumberLength(userNumber: List<Int>) {
    if (userNumber.size != LENGTH) {
        throw IllegalArgumentException()
    }
}

private fun checkUserNumberValidate(userNumber: List<Int>) {
    for (i in userNumber) {
        if (i < START || i > END) {
            throw IllegalArgumentException()
        } else {
            continue
        }
    }
}

private fun calculateUserScore(computerNumber: MutableList<Int>, userNumber: List<Int>) {
    var strike = 0
    var ball = 0
    userNumber.forEachIndexed { index, number ->
        if (computerNumber[index] == userNumber[index]) {
            strike++
        } else if (number in computerNumber) {
            ball++
        }
    }
    return printGameResult(strike, ball)
}

private fun printGameResult(strike: Int, ball: Int) {
    if (strike == LENGTH) {
        println("${strike}스트라이크")
        printGameEnd()
    } else if (strike > 0 && ball > 0) {
        println("${ball}볼 ${strike}스트라이크")
    } else if (strike > 0 && ball == 0) {
        println("${strike}스트라이크")
    } else if (strike == 0 && ball > 0) {
        println("${ball}볼")
    } else {
        println("낫싱")
    }
}

private fun printGameEnd() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

private fun isRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException()
    }
}