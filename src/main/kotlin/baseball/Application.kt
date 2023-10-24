package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val STRIKE_COUNT_TO_WIN = 3
const val REPLAY = "1"
const val EXIT = "2"

const val INVALID_INPUT_NUMBERS_EXCEPTION = "입력값이 올바르지 않습니다. 서로 다른 숫자 3개를 입력해주세요."
const val INVALID_INPUT_REPLAY_EXCEPTION = "입력값이 올바르지 않습니다. 1 또는 2를 입력해주세요."


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        playGame()
    } while (askReplay())
}

fun playGame() {
    val computerNumbers = generateComputerNumbers()
    do {
        val playerNumbers = getValidPlayerNumbers()
        val (strikeCount,ballCount) = calculateStrikeAndBallCounts(computerNumbers,playerNumbers)
        printResult(strikeCount, ballCount)
    } while (strikeCount != STRIKE_COUNT_TO_WIN)
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
    if (playerInputNumbers.size != 3 || playerInputNumbers.toSet().size != 3 || !playerInputNumbers.all { it.isDigit() } || playerInputNumbers.contains(
            '0'
        )) {
        throw IllegalArgumentException(INVALID_INPUT_NUMBERS_EXCEPTION)
    }
}

fun calculateStrikeAndBallCounts(computerNumbers: List<Int>, playerNumbers: List<Int>): Pair<Int, Int> {
    val strikeCount = calculateStrikeCount(computerNumbers,playerNumbers)
    val ballCount = calculateBallCount(computerNumbers,playerNumbers)
    return Pair(strikeCount, ballCount)
}

fun calculateStrikeCount(computerNumbers: List<Int>, playerNumbers: List<Int>) =
    computerNumbers.indices.count { i -> computerNumbers[i] == playerNumbers[i] }

fun calculateBallCount(computerNumbers: List<Int>, playerNumbers: List<Int>) =
    playerNumbers.filterIndexed { i, playerNumber -> playerNumber in computerNumbers && computerNumbers[i] != playerNumber }.size

fun printResult(strikeCount: Int, ballCount: Int) {
    when {
        strikeCount == STRIKE_COUNT_TO_WIN -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        ballCount > 0 && strikeCount > 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
        ballCount > 0 -> println("${ballCount}볼")
        strikeCount > 0 -> println("${strikeCount}스트라이크")
        else -> println("낫싱")
    }
}

fun askReplay(): Boolean {
    val playerInputForReplay = getPlayerInputForReplay()
    return continueOrExit(playerInputForReplay)
}

fun getPlayerInputForReplay(): String {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return Console.readLine()
}

fun continueOrExit(playerInputForReplay: String): Boolean {
    return when (playerInputForReplay) {
        REPLAY -> true
        EXIT -> false
        else -> throw IllegalArgumentException(INVALID_INPUT_REPLAY_EXCEPTION)
    }
}