package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

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

fun main() {
    var secretNumber = makeSecretNumber()
    var guessNumber = Console.readLine()
    if (!isValidInput(guessNumber)) {
        throw IllegalArgumentException("Wrong Input")
    }
}
