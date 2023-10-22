package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class Game {
    private val user = User()
    private val computer = Computer()

    fun printGameStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun gameStart() {
        val computerNumber = computer.setComputerNumber()
        println(computerNumber)

        while (computer.gameFlag) {
            val userNumber = user.inputUserNumber()
            computer.compareAndPrintHint(computerNumber, userNumber)

            if (!computer.gameFlag) {
                printGameEndMessage()
                decideGame()
            }
        }
    }

    private fun printGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    private fun decideGame() {
        val userInput = Console.readLine()
        checkValidInput(userInput)

        if (userInput == "1") {
            computer.gameFlag = true
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