package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
}

fun startBaseballGame() {
    val answer = creatRandomNumberList()
}

fun creatRandomNumberList(): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber))
            numbers.add(randomNumber)
    }
    return numbers
}