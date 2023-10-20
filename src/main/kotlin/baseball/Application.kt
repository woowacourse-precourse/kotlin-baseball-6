package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    startGame()
    inputNumber()
}

fun startGame() = println("숫자 야구 게임을 시작합니다.")
fun inputNumber() {
    print("숫자를 입력해주세요 : ")
    val inputNumber = Console.readLine()
    checkLength(inputNumber)
}

fun callException(): Nothing = throw IllegalArgumentException("잘못")

fun checkLength(inputNumber: String) {
    if (inputNumber.length != 3) {
        callException()
    }
}