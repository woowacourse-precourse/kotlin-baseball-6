package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")

}

fun playGame() {


}

fun genAnswer() : String {
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }
    return answer.joinToString("")
}

fun getInput() : String {
    val userInput = Console.readLine()

    validateInput(userInput)
    return userInput
}

fun validateInput(userInput: String) {
    var tmpList = mutableListOf<Char>()

    // 사용자의 입력이 세 글자가 아닌 경우
    if (userInput.length != 3) {
        throw IllegalArgumentException("세 글자가 아닙니다.")
    }

    for (index in userInput.indices) {
        // 사용자의 입력이 숫자가 아니거나 1부터 9까지의 정수가 아닌 경우
        if (userInput[index] < '1' || userInput[index] > '9') {
            throw IllegalArgumentException("1부터 9까지의 정수만 입력하실 수 있습니다.")
        }
        // 사용자의 입력에서 같은 숫자가 중복될 경우
        if (tmpList.contains(userInput[index])) {
            throw IllegalArgumentException("각 숫자는 달라야 합니다.")
        }
        tmpList.add(userInput[index])
    }

}