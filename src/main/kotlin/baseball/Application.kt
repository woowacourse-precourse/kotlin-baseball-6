package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        playGame()
        if (!isRestart()) {
            break
        }
    }
}

fun playGame() {
    val answer = generateAnswer()
    while (true) {
        val input = getUserAnswerInput()
        val judgeResult = judge(input, answer)
        judgeResult.print()
        if (judgeResult.isCorrect) {
            break
        }
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
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

fun judge(input: String, answer: String): JudgeResult {
    var ball = 0
    var strike = 0
    val answerDigits = answer.map { it.digitToInt() }.toSet()

    input.forEachIndexed { index, c ->
        if (answer[index] == c) {
            strike++
        } else if (answerDigits.contains(c.digitToInt())) {
            ball++
        }
    }

    return JudgeResult(ball, strike)
}

fun isRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = Console.readLine()
    return when (input) {
        "1" -> true
        "2" -> false
        else -> wrongInput()
    }
}