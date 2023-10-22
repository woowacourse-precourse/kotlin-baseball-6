package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class Game {
    private val user = User()
    private var gameFlag = true

    fun printGameStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun gameStart() {
        val computerNumber = setComputerNumber()
        println(computerNumber)

        while (gameFlag) {
            val userNumber = user.inputUserNumber()
            compareAndPrintHint(computerNumber, userNumber)

            if (!gameFlag) {
                printGameEndMessage()
                decideGame()
            }
        }
    }

    private fun setComputerNumber(): MutableList<Int> {
        val computer = mutableListOf<Int>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        return computer
    }

    private fun countStrikeAndBall(computer: MutableList<Int>, user: MutableList<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0

        user.forEach {
            if (computer.contains(it)) {
                ball++
            }
        }

        for (i in user.indices) {
            if (user[i] == computer[i]) {
                strike++
                ball--
            }
        }

        if (strike == 3) {
            gameFlag = false
        }

        return Pair(strike, ball)
    }

    private fun compareAndPrintHint(computer: MutableList<Int>, user: MutableList<Int>) {
        val (strike, ball) = countStrikeAndBall(computer, user)
        val hint = when {
            strike == 0 && ball == 0 -> "낫싱"
            strike > 0 && ball == 0 -> "${strike}스트라이크"
            strike == 0 && ball > 0 -> "${ball}볼"
            else -> "${ball}볼 ${strike}스트라이크"
        }

        println(hint)
    }

    private fun printGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    private fun decideGame() {
        val userInput = Console.readLine()
        checkValidInput(userInput)

        if (userInput == "1") {
            gameFlag = true
            gameStart()
        }
    }

    private fun checkValidInput(input: String) {
        if (input == "1" || input == "2") {
            return
        }

        throw IllegalArgumentException("입력이 1 또는 2가 아닙니다.")
    }
}