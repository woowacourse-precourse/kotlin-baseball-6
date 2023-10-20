package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumbers(): List<Int> {
    val computerNumbers = mutableSetOf<Int>()
    while (computerNumbers.size < 3) {
        computerNumbers.add(Randoms.pickNumberInRange(1, 9))
    }
    return computerNumbers.toList()
}