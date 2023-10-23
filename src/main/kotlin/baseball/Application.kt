package baseball

import camp.nextstep.edu.missionutils.Randoms

const val INPUT_SIZE = 3
fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        startGame()
    }
}

fun startGame() {
    val computer = generateRandomComputerNumber()
}

fun generateRandomComputerNumber() : List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < INPUT_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber)) computer.add(randomNumber)
    }
    return computer
}
