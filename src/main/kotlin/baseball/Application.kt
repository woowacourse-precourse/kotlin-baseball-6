package baseball

import baseball.Util.Validator.validateInteger
import baseball.Util.Validator.validateLength
import baseball.Util.Validator.validateRange
import baseball.Util.Validator.validateUniqueNumber
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printGameStart()
    val computerNumber = setComputerNumber()
    val userNumber = getUserInputList()

}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): String {
    return Console.readLine()
}

fun setComputerNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toList()
}

fun makeIntList(number: String): List<Int> {
    return number.map { it.digitToInt() }.toList()
}

fun getUserInputList(): List<Int> {
    val userInput = getUserInput()
    validateLength(userInput)
    validateInteger(userInput)
    validateRange(userInput)
    validateUniqueNumber(userInput)
    return makeIntList(userInput)
}
