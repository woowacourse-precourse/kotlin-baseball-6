package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import java.util.ArrayList

fun main() {
    makeRandomNumbers()
}

fun getUserInput(randomNumbers: MutableList<Int>){
    val userInput = readLine().map { it.digitToInt() }.toMutableList()
    val verifiedInput = validateInput(userInput)
    if (verifiedInput) {
        
    } else {
        throw IllegalArgumentException("입력값이 유효하지 않습니다. 게임을 종료합니다.")
    }
}

fun validateInput(userInput: MutableList<Int>): Boolean {
    val checkedUserInput = userInput.distinct()
    if (userInput.size != checkedUserInput.size || userInput.size != 3) {
        return false
    } else {
        return true
    }
}

fun makeRandomNumbers() {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
    getUserInput(randomNumbers)
}



