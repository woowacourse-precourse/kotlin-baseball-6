package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun createComputerList(): List<Int> {
    val computerList = mutableListOf<Int>()
    while (computerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumber !in computerList) {
            computerList.add(randomNumber)
        }
    }
    return computerList
}

fun checkRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = Console.readLine()
    return when (input) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("잘못된 입력입니다.")
    }
}

fun main() {
    while (true) {
        val computerList = createComputerList()
        val baseBall = BaseBall(computerList)
        baseBall.startGame(computerList)
        if (!checkRestart()) {
            break
        }
    }
}




