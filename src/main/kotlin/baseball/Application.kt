package baseball

import camp.nextstep.edu.missionutils.Console.*

private const val INPUT_MIN_VALUE = 111
private const val INPUT_MAX_VALUE = 999

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
}

private fun startBaseballGame() {
    print("숫자를 입력해주세요 : ")

    try {
        val inputBaseballNumbers = validateInput(readLine().toInt())
    } catch (exception: Exception) {
        when(exception) {
            is IllegalStateException -> println("잘못된 값을 입력하셨습니다.")
            else -> println("잘못된 값을 입력하셨습니다.")
        }
        return
    }
}

private fun validateInput(input: Int) {
    if (input !in INPUT_MIN_VALUE..INPUT_MAX_VALUE) {
        throw IllegalStateException()
    }
}
