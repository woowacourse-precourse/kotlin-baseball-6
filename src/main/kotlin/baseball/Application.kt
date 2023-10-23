package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


private const val RANDOM_START = 1
private const val RANDOM_END = 9
const val INPUT_NUMBER_COUNT = 3
const val WRONG_INPUT_MESSAGE = "잘못된 입력입니다."
fun main() {
    while (true) {
        val computerList = createComputerList()
        val baseBall = BaseBall()
        baseBall.startGame(computerList)
        if (!checkRestart()) {
            break
        }
    }
}

fun createComputerList(): List<Int> {
    val computerList = mutableListOf<Int>()
    while (computerList.size < INPUT_NUMBER_COUNT) {
        val randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END)
        if (randomNumber !in computerList) {
            computerList.add(randomNumber)
        }
    }
    return computerList
}

fun checkRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
    }
}