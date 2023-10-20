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

fun calculateBallCount(computerNumbers: List<Int>, playerNumbers: List<Int>) =
    playerNumbers.filterIndexed { i, playerNumber -> playerNumber in computerNumbers && computerNumbers[i] != playerNumber }.size

fun printResult(strikeCount: Int, ballCount: Int) {
    when {
        strikeCount == 3 -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        ballCount > 0 && strikeCount > 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
        ballCount > 0 -> println("${ballCount}볼")
        strikeCount > 0 -> println("${strikeCount}스트라이크")
        else -> println("낫싱")
    }
}

fun askReplay(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val playerInput = Console.readLine()
    return when (playerInput) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("ERROR")
    }
}