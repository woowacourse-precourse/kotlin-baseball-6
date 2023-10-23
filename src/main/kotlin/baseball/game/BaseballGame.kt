package baseball.game

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class BaseballGame(val digits: Int = 3) {
    val name = "숫자 야구 게임"
    fun start() {
        println("${name}을 시작합니다.")
        val answer: List<Int> = generateRandomAnswer(digits)
        println(answer)
        var result = ""
        while (result != "GameClear") {
            print("숫자를 입력해주세요 : ")
            val userInput: String = Console.readLine().trim()
            val userAnswer: List<Int> = validate(userInput)
            result = resultString(answer, userAnswer)
            println(result)
        }
    }

    private fun generateRandomAnswer(digits: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < digits) {
            val num = pickNumberInRange(1, 9)
            if (num !in numbers) {
                numbers.add(num)
            }
        }
        return numbers
    }

    private fun validate(userInput: String): List<Int> {
        val validAnswer: List<Int>

        if (userInput.length != digits)
            throw IllegalArgumentException("자릿수 불일치.")

        try {
            validAnswer = userInput.map { it.toString().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아님.")
        }

        for (num in validAnswer) {
            if (num == 0) throw IllegalArgumentException("1 ~ 9 범위의 숫자로 구성 필요.")
        }

        if (validAnswer.toSet().size != validAnswer.size) throw IllegalArgumentException("서로 다른 수 입력 필요")

        return validAnswer
    }

    private fun resultString(answer: List<Int>, userAnswer: List<Int>): String {
        var strikeCount = 0
        var ballCount = 0
        var nothingCount = 0
        for (num in userAnswer) {
            if (num in answer) {
                if (userAnswer.indexOf(num) == answer.indexOf(num)) strikeCount++
                else ballCount++
            } else nothingCount++
        }
        if (strikeCount == 3) return "GameClear"
        if (nothingCount == 3) return "낫싱"
        return "${ballCount}볼 ${strikeCount}스트라이크"
    }
}