package baseball

import camp.nextstep.edu.missionutils.Randoms

const val INPUT_SIZE = 3
const val NO_INPUT = 0

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        startGame()
    }
}

fun startGame() {
    val computer = generateRandomComputerNumber()
    Baseball().run(computer)
}

fun generateRandomComputerNumber() : List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < INPUT_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber)) computer.add(randomNumber)
    }
    return computer
}
