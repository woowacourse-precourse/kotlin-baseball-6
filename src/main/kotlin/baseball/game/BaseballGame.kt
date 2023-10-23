package baseball.game

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class BaseballGame(val digits: Int = 3) {
    val name = "숫자 야구 게임"
    fun start() {
        println("${name}을 시작합니다.")
        val answer: List<Int> = generateRandomAnswer(digits)
        print("숫자를 입력해주세요 : ")
        val userInput: String = Console.readLine().trim()
        val userAnswer: List<Int> = validate(userInput)
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
}