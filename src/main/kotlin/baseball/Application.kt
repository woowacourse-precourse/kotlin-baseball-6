package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    while (true) {
        playGame()
        if (!isRestart()) {
            break
        }
    }
}

fun playGame() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val input = getUserAnswerInput()
        println(input)
    }
}

fun getUserAnswerInput(): String {
    print("숫자를 입력해주세요 : ")
    val rawInput = Console.readLine()
    val digits = mutableSetOf<Int>()
    try {
        rawInput.forEach { char ->
            digits.add(char.digitToInt())
        }
    } catch (e: Exception) {
        wrongInput()
    }

    if (digits.size != 3 || digits.contains(0)) {
        wrongInput()
    }
    return rawInput
}

fun isRestart(): Boolean {
    return false
}

fun wrongInput() {
    throw IllegalArgumentException("잘못된 입력")
}

fun generateAnswer(): String {
    val digits = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    return digits.joinToString(separator = "")
}