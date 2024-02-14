package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    val numberSize = 3

    val computer = mutableListOf<Int>()
    while (computer.size < numberSize) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    while (true) {
        print("숫자를 입력해주세요 : ")
        val inputNumbers = Console.readLine()

        if (inputNumbers.length != numberSize) {
            throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
        }

    }
}
