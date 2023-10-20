package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
    inputNumber()
    val randomNumber = createRandomNumber()
    println(randomNumber)
}

fun startGame() = println("숫자 야구 게임을 시작합니다.")
fun inputNumber() {
    print("숫자를 입력해주세요 : ")
    val inputNumber = Console.readLine()
    checkLength(inputNumber)
    checkIsDigit(inputNumber)
    checkDifferentNumber(inputNumber)
}

fun callException(): Nothing = throw IllegalArgumentException("잘못")

fun checkLength(inputNumber: String) {
    if (inputNumber.length != 3) {
        callException()
    }
}

fun checkDifferentNumber(inputNumber: String) {
    if (inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
        callException()
    }
}

fun checkIsDigit(inputNumber: String) {
    inputNumber.forEach {
        if (49 > it.code || 57 < it.code) callException()
    }
}

fun createRandomNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}