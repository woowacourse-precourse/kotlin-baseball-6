package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun printGameStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun setComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun inputUserNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")

    return Console.readLine().map { it.digitToInt() }.toMutableList()
}


fun main() {
    printGameStartMessage()
    val computerNumber = setComputerNumber()
    var userNumber = inputUserNumber()
}
