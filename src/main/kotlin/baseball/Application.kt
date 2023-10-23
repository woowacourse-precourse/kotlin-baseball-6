package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class GuessResult(
    val ballNumber: Int,
    val strikeNumber: Int
)

fun makeSecretNumber(): String {
    val stringBuilder = StringBuilder()
    repeat(3) {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        stringBuilder.append(randomNumber)
    }
    return stringBuilder.toString()
}

fun isValidInput(input: String): Boolean {
    return input.all { isNumber(it) } && input.length == 3
}

fun isNumber(input: Char) = input in '0'..'9'

fun getGuessResult(secretNumber: String, guessNumber: String): GuessResult {
    val ball = countBall(secretNumber, guessNumber)
    val strike = countStrike(secretNumber, guessNumber)
    return GuessResult(ball, strike)
}

fun countBall(secretNumber: String, guessNumber: String): Int {
    var ball = 0
    for (secretIt in secretNumber) {
        for (guessIt in guessNumber) {
            if (secretIt == guessIt) {
                ball++
            }
        }
    }
    return ball
}

fun countStrike(secretNumber: String, guessNumber: String): Int {
    var strike = 0
    for (it in 0 until 3) {
        if (secretNumber[it] == guessNumber[it]) {
            strike++
        }
    }
    return strike
}

fun main() {
    val secretNumber = makeSecretNumber()
    val guessNumber = Console.readLine()
    if (!isValidInput(guessNumber)) {
        throw IllegalArgumentException("Wrong Input")
    }

}
