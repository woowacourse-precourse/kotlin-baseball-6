package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    printGameStart()
    val userInput = getUserInput()
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): String {
    return Console.readLine()
}
