package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    NumberBaseballGame().start()
}

class NumberBaseballGame {
    private val output = OutputWriter()
    fun start() {
        output.printGameStart()
        output.printReceiveNumberInput()
        val user = inputUserNumbers()
        val computer = generateRandomNumbers()
        val (strike, ball) = checkGuess(user,computer)
        output.printGuessResult(strike,ball)
    }

    //서로 다른 3자리의 수 입력
    private fun inputUserNumbers(): List<Int> {
        val input = Console.readLine()

        if (input.length != 3 || input.toSet().size != 3) {
            throw IllegalArgumentException()
        }

        val user = input.map { it.toString().toInt() }

        return user
    }

    //1~9 범위의 서로 다른 3자리의 수 생성
    private fun generateRandomNumbers(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    //컴퓨터와 사용자 입력값 비교
    private fun checkGuess(user: List<Int>, computer: List<Int>): Pair<Int,Int> {
        var strike = 0
        var ball = 0

        for (i in user.indices) {
            if (user[i] == computer[i]) {
                strike++
            } else if (computer.contains(user[i])) {
                ball++
            }
        }
        return strike to ball
    }
}

class OutputWriter {
    fun printGameStart() = println("숫자 야구 게임을 시작합니다.")
    fun printReceiveNumberInput() = print("숫자를 입력해주세요 : ")
    fun printGuessResult(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) {
            printNothingResult()
        }else if (ball >0 && strike == 0) {
            printOnlyBalls(ball)
        }else if (ball == 0 && strike > 0) {
            printOnlyStrikes(strike)
        }else {
            printBallAndStrike(ball, strike)
        }
    }

    private fun printNothingResult() = println("낫싱")
    private fun printOnlyBalls(ball: Int) = println("${ball}볼")
    private fun printOnlyStrikes(strike: Int) = println("${strike}스트라이크")
    private fun printBallAndStrike(ball: Int, strike: Int) = println("${ball}볼 ${strike}스트라이크")
}
