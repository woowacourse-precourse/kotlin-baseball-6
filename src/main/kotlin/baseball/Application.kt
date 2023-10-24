package baseball

import camp.nextstep.edu.missionutils.*


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
    continueOrQuit()
}

fun startBaseballGame() {
    val computer = randomComputer()

}

fun continueOrQuit() {
    TODO("Not yet implemented")
}

// 1) '컴퓨터의 숫자' 초기화
fun randomComputer(): List<Int> {
    val rand = mutableListOf<Int>()

    while (rand.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!rand.contains(randomNumber)) {
            rand.add(randomNumber)
        }
    }

    return rand
}