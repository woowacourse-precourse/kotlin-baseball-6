package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

data class GuessResult(val strikes: Int, val balls: Int)

fun evaluateGuess(userNumbers: List<Int>, computerNumbers: List<Int>): GuessResult {
    var strikes = 0
    var balls = 0

    for (i in userNumbers.indices) {
        if (userNumbers[i] == computerNumbers[i]) {
            strikes++
        } else if (userNumbers[i] in computerNumbers) {
            balls++
        }
    }

    return GuessResult(strikes, balls)
}

fun generateComputerNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}