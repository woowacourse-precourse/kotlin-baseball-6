package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import kotlin.math.absoluteValue

fun main() {
    val collectNumber = creatNumbers()
    val userAnswer = userInput()
}

fun creatNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println("숫자 야구 게임을 시작합니다.")
    return computer
}

fun userInput(): List<Int> {
    print("서로 다른 3자리의 수를 입력해주세요 : ")
    val input = Console.readLine()
    val user = mutableListOf<Int>()
    input.forEach{
        user.add(it.toString().toInt())
    }
    return user
}