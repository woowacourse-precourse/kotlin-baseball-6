package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    private val computerNumbers = mutableListOf<Int>()

    init {
        generateComputer()
    }

    private fun generateComputer() {
        while (computerNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in computerNumbers) {
                computerNumbers.add(randomNumber)
            }
        }
    }

    fun play() {
        val userInput = getUserInput()
        val strikeCount = countStrikes(userInput)
        println("${strikeCount}스트라이크")
    }

    private fun countStrikes(userInput: List<Int>): Int {
        var strikeCount = 0
        for (i in 0..2) {
            if (computerNumbers[i] == userInput[i]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun getUserInput(): List<Int> {
        while (true) {
            try {
                print("숫자를 입력해 주세요 : ")
                val input = Console.readLine()
                return checkUserInput(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkUserInput(input: String): List<Int> {
        if (!isValid(input)) {
            throw IllegalArgumentException("잘못된 입력입니다. 1에서 9까지 서로 다른 수 3개를 입력해 주세요.")
        }
        return input.map { it.toString().toInt() }
    }

    private fun isValid(input: String): Boolean {
        return input.length == 3 &&
                input.all { it in '1'..'9' } &&
                input.toSet().size == 3
    }
}

fun main() {
    val baseballGame = BaseballGame()

    println("숫자 야구 게임을 시작합니다.")
    baseballGame.play()
}