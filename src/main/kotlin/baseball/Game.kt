package baseball

import baseball.utils.RandomNumberGenerator
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
            if (checkStrike(userInput, computer)) {
                return
            }
        }
    }

    private fun checkStrike(input: String, answer: List<Int>): Boolean {
        var strike = 0
        var ball = 0
        for (i in 0..2) {
            val current = input[i].digitToInt()
            if (current == answer[i]) {
                strike++
            } else if (current in answer) {
                ball++
            }
        }

        if (strike == 3) {
            println("3스트라이크")
            return true
        }

        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else {
            var str = ""
            if (ball > 0) str = "${ball}볼 "
            if (strike > 0) str += "${strike}스트라이크"
            println(str)
        }

        return false
    }

    private fun playNextGame(): Boolean {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer = Console.readLine()
        checkNextGameAnswer(answer)
        return answer == "1"
    }

    private fun checkAnswerInput(input: String) {
        if (input.length != 3 || !input.all { char -> char.isDigit() } || input.toSet().size != 3) {
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