package baseball.game

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val GAME_DIGITS = 3

class BaseballGame(val digits: Int = GAME_DIGITS) {
    val name = "숫자 야구 게임"

    init {
        println("${name}을 시작합니다.")
    }

    fun start() {
        val answer: List<Int> = generateRandomAnswer(digits)
        var result = ""
        while (result != "3스트라이크") {
            print("숫자를 입력해주세요 : ")
            val userInput: String = Console.readLine().trim()
            val userAnswer: List<Int> = validateUserInput(userInput)
            result = compareResult(answer, userAnswer)
            println(result)
        }
        restartProcess()
    }

    private fun restartProcess() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        when (Console.readLine().trim()) {
            "1" -> start()
            "2" -> Unit
            else -> throw IllegalArgumentException("1 혹은 2만 입력 가능.")
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

    private fun validateUserInput(userInput: String): List<Int> {
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

    private fun compareResult(answer: List<Int>, userAnswer: List<Int>): String {
        var strikeCount = 0
        var ballCount = 0
        for (num in userAnswer) {
            if (num in answer) {
                if (userAnswer.indexOf(num) == answer.indexOf(num)) strikeCount++
                else ballCount++
            }
        }

        if (strikeCount == 0 && ballCount == 0) return "낫싱"
        else if (strikeCount == 0) return "${ballCount}볼"
        else if (ballCount == 0) return "${strikeCount}스트라이크"
        return "${ballCount}볼 ${strikeCount}스트라이크"
    }
}