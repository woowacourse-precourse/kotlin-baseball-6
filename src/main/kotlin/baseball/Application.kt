package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun getComputerNumList(): MutableList<Int> {
    val computerNumList = mutableListOf<Int>()
    while (computerNumList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumList.contains(randomNumber)) {
            computerNumList.add(randomNumber)
        }
    }
    return computerNumList
}

fun getUserNum(): MutableList<Int> {
    val userInput = Console.readLine().toString()

    if (!isUserNumValid(userInput)) {
        throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리의 수로 다시 입력해주세요.")
    }
    return userInput.toCharArray()
        .map { it.digitToInt() }
        .toMutableList()

}

fun isUserNumValid(userInput: String): Boolean{
    if (userInput != null) {
        if (!userInput.trim().matches(Regex("\\d{3}"))) {
            throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리의 수로 다시 입력해주세요.")
            return false
        } else if (userInput.toCharArray().map { it.digitToInt() }.toMutableList().distinct().size != 3) {
            throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리의 수로 다시 입력해주세요.")
            return false
        } else {
            return true
        }
    } else {
        throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 3자리의 수로 다시 입력해주세요.")
        return false
    }
}