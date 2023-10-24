package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 1. 게임 시작을 위한 세팅
    val answer = answerSelect()
    println("숫자 야구 게임을 시작합니다.")
    println("answer : ${answer}")
}

fun answerSelect(): ArrayList<Int> {
    val computer = arrayListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}