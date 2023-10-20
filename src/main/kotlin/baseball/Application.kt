package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    gameStartMessage()
    val computerNum = createRandomNum()
    val userNum = getUserInputNum()

}

fun gameStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun createRandomNum(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInputNum(): List<Int> {
    val userInputChar = Console.readLine().toCharArray()
    val inputNum = userInputChar.map { num -> num.toString().toInt() }
    return inputNum
}

