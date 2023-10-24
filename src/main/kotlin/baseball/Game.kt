package baseball

import baseball.utils.RandomNumberGenerator
import baseball.utils.containsDuplicatedNumber
import baseball.utils.isInt
import baseball.utils.isRangeOf
import camp.nextstep.edu.missionutils.Console

class Game {
    fun run() {
        println("숫자 야구 게임을 시작합니다.")
        val computer = RandomNumberGenerator.generate(1, 9, 3)
        while (true) {
            startGuessingAnswer(computer)

            if (playNextGame()) {
                break
            }
        }
    }

    private fun startGuessingAnswer(computer: List<Int>) {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()
            checkAnswerInput(userInput)
            println(calculateResult(userInput, computer))

            if (userInput.isAllStrike(computer)) {
                return
            }
        }
    }

    private fun String.isAllStrike(computer: List<Int>): Boolean {
        computer.forEachIndexed { index, value ->
            if (value != this[index].digitToInt()) {
                return false
            }
        }
        return true
    }

    private fun calculateResult(input: String, answer: List<Int>): String {
        var strike = 0
        var ball = 0
        answer.forEachIndexed { index, value ->
            val current = input[index].digitToInt()
            if (current == value) {
                strike++
            } else if (current in answer) {
                ball++
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱"
        }

        return buildString {
            if (ball > 0) append(ball).append("볼 ")
            if (strike > 0) append(strike).append("스트라이크")
        }
    }

    private fun playNextGame(): Boolean {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer = Console.readLine()
        checkNextGameAnswer(answer)
        return answer == "1"
    }

    private fun checkAnswerInput(input: String) {
        if (input.length != 3) {
            throwIllegalException()
        }

        if (!input.isInt(includeSign = false)) {
            throwIllegalException()
        }

        if (input.containsDuplicatedNumber()) {
            throwIllegalException()
        }

        if (!input.isRangeOf(1, 9)) {
            throwIllegalException()
        }
    }

    private fun checkNextGameAnswer(input: String) {
        if (input == "1" || input == "2") {
            return
        }
        throwIllegalException()
    }

    private fun throwIllegalException() {
        throw IllegalArgumentException("입력 값이 올바르지 않음")
    }
}