package baseball

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
