package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    val user = mutableListOf<Int>()

    var strike = 0
    var ball = 0

    setComputerNums(computer)

    val input = Console.readLine()
    input.forEach { user.add(it.digitToInt()) }

    computer.forEachIndexed { i, value ->
        repeat(3) { j ->
            if(i == j) { if(value == user[i]) strike++ }
            else { if(value == user[j]) ball++ }
        }
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