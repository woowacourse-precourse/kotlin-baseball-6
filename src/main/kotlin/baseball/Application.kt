package baseball

import camp.nextstep.edu.missionutils.Console.*
import camp.nextstep.edu.missionutils.Randoms.*

private const val RANDOM_MIN_VALUE = 1
private const val RANDOM_MAX_VALUE = 9

private const val INPUT_MIN_VALUE = 111
private const val INPUT_MAX_VALUE = 999

private const val BASEBALL_NUMBER_COUNT = 3

private const val RESTART = "1"
private const val EXIT = "2"

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
}

private fun startBaseballGame() {
    var randomBaseballNumbers: MutableList<Int> = getRandomNumbers()
    try {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userBaseballNumbers: Int = validateInput(readLine().toInt())
            val baseballResult: Boolean= isAnswer(randomBaseballNumbers, userBaseballNumbers)

            if (baseballResult) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                val input: String = restartOrExitInput(readLine())
                if (input == EXIT) break
                randomBaseballNumbers = getRandomNumbers()
            }
        }
    } catch (exception: Exception) {
        when (exception) {
            is IllegalStateException -> println("잘못된 값을 입력하셨습니다.")
            else -> println("IllegalStateException 예외가 아닙니다.")
        }
        return
    }
    println("프로그램 종료.")
}

private fun validateInput(input: Int): Int {
    if (input !in INPUT_MIN_VALUE..INPUT_MAX_VALUE) {
        throw IllegalStateException()
    } else {
        return input
    }
}

private fun restartOrExitInput(input: String): String {
    if (!(input == RESTART || input == EXIT)) {
        throw IllegalStateException()
    } else {
        return input
    }
}

private fun getRandomNumbers(): MutableList<Int> {
    val numberList = mutableListOf<Int>()
    while (numberList.size < BASEBALL_NUMBER_COUNT) {
        val randomNumber = pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
    return numberList
}

private fun isAnswer(
    randomBaseballNumbers: MutableList<Int>,
    userBaseballNumbers: Int
): Boolean {
    var strike = 0
    var ball = 0

    val userBaseballNumberList: List<Int> = userBaseballNumbers
        .toString()
        .map { it.toString().toInt() }

    randomBaseballNumbers.forEachIndexed { index, number ->
        when {
            userBaseballNumberList[index] == number -> strike++
            randomBaseballNumbers.contains(userBaseballNumberList[index]) -> ball++
        }
    }

    when {
        strike + ball == 0 -> println("낫싱")
        strike == 0 -> println("${ball}볼")
        ball == 0 -> println("${strike}스트라이크")
        else -> println("${ball}볼${strike}스트라이크")
    }

    return strike == BASEBALL_NUMBER_COUNT
}
