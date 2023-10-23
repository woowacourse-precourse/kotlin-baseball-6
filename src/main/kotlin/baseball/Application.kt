package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
}

//1~9 범위의 서로 다른 3자리의 수 생성
private fun generateRandomNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
