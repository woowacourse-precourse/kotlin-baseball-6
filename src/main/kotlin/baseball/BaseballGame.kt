package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine

class BaseballGame {
    private var computerNum = mutableListOf<Int>()

    init {
        generateRandomNumber()
    }

    private fun generateRandomNumber() {
        computerNum = mutableListOf<Int>()
        while (computerNum.size < 3) {
            val randomNumber = pickNumberInRange(1, 9)
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber)
            }
        }
    }


    fun start() {
        println("숫자 야구 게임을 시작합니다.")
        playgame()
    }

    fun playgame() {
        var isGameEnd = false

        while (!isGameEnd) {
            try {
                val userInput = getUserInput()
                val result = calculateResult(userInput)
                printResult(result)

                if (result == "3스트라이크") {
                    printResult("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    isGameEnd = true
                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = readLine()
        if (userInput.length != 1 || userInput.any { !it.isDigit() }) {
            throw IllegalArgumentException("입력값은 1자리의 숫자여야 합니다.")
        }
        val restartOrExit = userInput.toInt()
        if (restartOrExit == 1) {
            generateRandomNumber()
            playgame()
        }
    }
    private fun getUserInput(): List<Int> {
        println("숫자를 입력해주세요 : ")
        val userInput = readLine()

        if (userInput.length != 3 || userInput.any { !it.isDigit() }) {
            throw IllegalArgumentException("입력값은 3자리의 숫자여야 합니다.")
        }

        return userInput.map { it.toString().toInt() }
    }

    private fun calculateResult(userInput: List<Int>): String {
        var strikeCount = 0
        var ballCount = 0

        for (i in userInput.indices) {
            if (userInput[i] == computerNum[i]) {
                strikeCount++
            } else if (computerNum.contains(userInput[i])) {
                ballCount++
            }
        }

        return when {
            strikeCount == 3 -> "3스트라이크"
            strikeCount > 0 && ballCount > 0 -> "$ballCount 볼 $strikeCount 스트라이크"
            strikeCount > 0 -> "$strikeCount 스트라이크"
            ballCount > 0 -> "$ballCount 볼"
            else -> "낫싱"
        }
    }

    private fun printResult(result: String) {
        println(result)
    }
}