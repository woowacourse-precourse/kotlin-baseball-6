package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

private const val START = 1
private const val END = 9
private const val LENGTH = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        val computer = generateRandomNumberList()
        startGame(computer)
    } while (isRestart())
    return
}

private fun startGame(computer: List<Int>) {
    do {
        val user = inputUserNumber()
        calculateScore(computer, user)
    } while (computer != user)
}

private fun isRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("1 또는 2가 아닙니다")
    }
}

private fun inputUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val user = Console.readLine()
    return checkUserInput(user)
}

private fun readLine(): String = Console.readLine() ?: ""

private fun calculateScore(computer: List<Int>, user: List<Int>) {
    var strike = 0
    var ball = 0

    computer.forEachIndexed { index, s ->
        if (computer[index] == user[index]) {
            strike++
        } else if (s in user) {
            ball++
        }
    }

    printScore(strike, ball)
}

private fun printScore(strike: Int, ball: Int) {
    when {
        strike == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }

        strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
        strike > 0 -> println("${strike}스트라이크")
        ball > 0 -> println("${ball}볼")
        else -> println("낫싱")
    }
}

private fun generateRandomNumberList(): List<Int> {
    val numberSet = mutableSetOf<Int>()

    while (numberSet.size < LENGTH) {
        numberSet.add(pickNumberInRange(START, END))
    }
    return numberSet.toList()
}

private fun checkUserInput(userInput: String): List<Int> {
    try {
        validateNumberLength(userInput)
        validateNumberInRange(userInput)
        return userInput.map { it.toString().toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자가 아닙니다.")
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

private fun validateNumberInRange(userInput: String) {
    userInput.forEach { number ->
        if (number.toString().toInt() < START || number.toString().toInt() > END) {
            throw IllegalArgumentException("범위에 속하지 않은 숫자입니다.")
        }
    }
}

private fun validateNumberLength(userInput: String) {
    if (userInput.length != LENGTH) {
        throw IllegalArgumentException("세 자리가 아닙니다.")
    }
}
