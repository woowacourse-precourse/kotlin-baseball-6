package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import util.Constants.DUPLICATE_NUMBER_MESSAGE
import util.Constants.INPUT_MESSAGE
import util.Constants.INVALID_INPUT_MESSAGE
import util.Constants.INVALID_LENGTH_MESSAGE

fun main() {
    val game = BaseballGame()
    game.startBaseballGame()
}

fun creatRandomNumbers(): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) numbers.add(randomNumber)
    }
    return numbers
}

fun getUserInput(): MutableList<Int> {
    print(INPUT_MESSAGE)
    val userInput = Console.readLine()
    isUserInputValid(userInput)
    var userNumber = userInput.toInt()
    val userNumberList = mutableListOf<Int>()
    repeat(3) {
        userNumberList.add(0, userNumber % 10)
        userNumber /= 10
    }
    return userNumberList
}

fun isUserInputValid(userInput: String) {
    if (!userInput.all { it.isDigit() }) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
    if (userInput.length != 3) throw IllegalArgumentException(INVALID_LENGTH_MESSAGE)
    if (userInput.toSet().size != userInput.length) throw IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE)
}