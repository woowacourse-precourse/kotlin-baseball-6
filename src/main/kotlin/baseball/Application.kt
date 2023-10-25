package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    makeRandomNumbers()
    getUserInput()
}

fun getUserInput() {
    val userInput = readLine().map { it.digitToInt() }.toMutableList()
}


fun makeRandomNumbers() {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
}



