package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().run()
}

class Application {

    private val game = Game()

    fun run() {
        println("숫자 야구 게임을 시작합니다.")
        game.start()
    }
}

class Game {

    private var computerNumbers = mutableListOf<Int>()

    fun start() {
        generateRandomNumbers()
        while (true) {
            val userInput = getUserInput()
            val (strikes, balls) = compareNumbers(userInput)
            printResult(strikes, balls)
            if (strikes == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                if (askForRestart() == 2) break
                generateRandomNumbers()
            }
        }
    }

    private fun generateRandomNumbers() {
        computerNumbers.clear()
        while (computerNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber)
            }
        }
    }

    private fun getUserInput(): List<Int> {
        println("숫자를 입력해주세요 : ")
        return Console.readLine().map { it.toString().toInt() }
    }

    private fun compareNumbers(userInput: List<Int>): Pair<Int, Int> {
        var strikes = 0
        var balls = 0
        for (i in userInput.indices) {
            if (userInput[i] == computerNumbers[i]) {
                strikes++
            } else if (computerNumbers.contains(userInput[i])) {
                balls++
            }
        }
        return Pair(strikes, balls)
    }

    private fun printResult(strikes: Int, balls: Int) {
        when {
            strikes == 0 && balls == 0 -> println("낫싱")
            strikes == 3 -> println("3스트라이크")
            else -> println("${balls}볼 ${strikes}스트라이크")
        }
    }

    private fun askForRestart(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine().toInt()
    }
}
