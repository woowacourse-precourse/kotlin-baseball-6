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