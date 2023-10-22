package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine


// 프로그램의 시작점
fun main() {
    // 게임을 시작한다.
    startGame()

    // 컴퓨터 숫자를 생성한다.
    println(createComputerNumber())

    // 플레이어 숫자를 입력 받는다.
    println(getPlayerNumber())
}

fun startGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun createComputerNumber(): MutableList<Int> {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getPlayerNumber(): String {

    print("숫자를 입력해주세요 : ")

    val player = readLine()

    return player
}