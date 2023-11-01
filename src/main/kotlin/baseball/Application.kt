package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    printGameStart()
    val userInput = getUserInput()
    validateLength(userInput)
    validateInteger(userInput)
    validateUniqueNumber(userInput)
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): String {
    return Console.readLine()
}

fun validateLength(number: String) {
    if (number.length != 3) throw IllegalArgumentException("사용자의 입력이 3자리가 아닙니다.")
}

fun validateInteger(number: String) {
    number.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 정수가 아닙니다.")
}

fun validateUniqueNumber(number: String) {
    val validation = number.toSet()
    if (validation.size != 3) throw IllegalArgumentException("사용자의 입력 중 중복된 숫자가 존재합니다.")
}
