package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumbers(): List<Int> {
    val computerNumbers = mutableSetOf<Int>()
    while (computerNumbers.size < 3) {
        computerNumbers.add(Randoms.pickNumberInRange(1, 9))
    }
    return computerNumbers.toList()
}

fun getValidPlayerNumbers(): List<Int> {
    val playerInputNumbers = getPlayerInputNumbers()
    validatePlayerInputNumbers(playerInputNumbers)
    return playerInputNumbers.map { it.toString().toInt() }
}

fun getPlayerInputNumbers(): List<Char> {
    print("숫자를 입력해주세요 : ")
    return Console.readLine().toList()
}

fun validatePlayerInputNumbers(playerInputNumbers: List<Char>) {
    if (playerInputNumbers.size != 3 || playerInputNumbers.toSet().size != 3 || !playerInputNumbers.all { it.isDigit() }) {
        throw IllegalArgumentException("ERROR")
    }
}

fun calculateStrikeCount(computerNumbers: List<Int>, playerNumbers: List<Int>) =
    computerNumbers.indices.count { i -> computerNumbers[i] == playerNumbers[i] }