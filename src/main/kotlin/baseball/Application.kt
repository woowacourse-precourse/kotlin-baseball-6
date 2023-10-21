package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import kotlin.math.absoluteValue

fun main() {
    val collectNumber = creatNumbers()
    var userAnswer: List<Int>? = null
    try {
        userAnswer = userInput()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
    println(collectNumber)
    println(userAnswer)
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
    validateInput(input)
    val user = mutableListOf<Int>()
    input.forEach {
        user.add(it.toString().toInt())
    }
    return user
}

fun validateInput(input: String) {
    // 숫자만 있는지 확인
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("입력은 숫자만 가능합니다.")
    }

    // 입력 길이 확인
    if (input.length != 3) {
        throw IllegalArgumentException("정확히 세 자리 숫자를 입력해주세요.")
    }

    // 중복된 숫자가 있는지 확인
    if (input.toSet().size != input.length) {
        throw IllegalArgumentException("숫자는 중복되지 않아야 합니다.")
    }
}