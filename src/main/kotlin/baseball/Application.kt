package baseball

import camp.nextstep.edu.missionutils.Console.*
import camp.nextstep.edu.missionutils.Randoms.*

private const val RANDOM_MIN_VALUE = 1
private const val RANDOM_MAX_VALUE = 9

private const val INPUT_MIN_VALUE = 111
private const val INPUT_MAX_VALUE = 999

private const val BASEBALL_NUMBER_COUNT = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
}

private fun startBaseballGame() {
    print("숫자를 입력해주세요 : ")

    val randomBaseballNumbers: MutableList<Int> = getRandomNumbers()

    try {
        val inputBaseballNumbers = validateInput(readLine().toInt())
    } catch (exception: Exception) {
        when(exception) {
            is IllegalStateException -> println("잘못된 값을 입력하셨습니다.")
            else -> println("잘못된 값을 입력하셨습니다.")
        }
        return
    }
}

private fun validateInput(input: Int): Int {
    if (input !in INPUT_MIN_VALUE..INPUT_MAX_VALUE) {
        throw IllegalStateException()
    } else {
        return input
    }
}

private fun getRandomNumbers(): MutableList<Int>{
    val numberList = mutableListOf<Int>()
    while(numberList.size < BASEBALL_NUMBER_COUNT) {
        val randomNumber =  pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
        if(!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
    return numberList
}
