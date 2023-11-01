package baseball

import baseball.Util.Validator.validateInteger
import baseball.Util.Validator.validateLength
import baseball.Util.Validator.validateRange
import baseball.Util.Validator.validateUniqueNumber
import camp.nextstep.edu.missionutils.Console

fun main() {
    printGameStart()
    val userInput = getUserInput()
    validateLength(userInput)
    validateInteger(userInput)
    validateRange(userInput)
    validateUniqueNumber(userInput)
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): String {
    return Console.readLine()
}
