package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    val user = mutableListOf<Int>()

    setComputerNums(computer)
    while (true) {
        print("숫자를 입력해주세요 : ")

        var strike = 0
        var ball = 0

        user.clear()
        val input = Console.readLine()
        input.forEach { user.add(it.digitToInt()) }

        computer.forEachIndexed { i, value ->
            repeat(3) { j ->
                if (i == j) { if (value == user[i]) strike++ }
                else { if (value == user[j]) ball++ }
            }
        }

        if (strike == 3) {
            println("${strike}스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        } else if (strike != 0 && ball != 0) println("${ball}볼 ${strike}스트라이크")
        else if (ball != 0) println("${ball}볼")
        else if (strike != 0) println("${strike}스트라이크")
        else print("낫싱")
    }
}

private fun setComputerNums(computer: MutableList<Int>) {
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}