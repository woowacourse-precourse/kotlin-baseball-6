package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import kotlin.random.Random

class Baseball {
    private var randomNumbers = listOf<Int>()
    private var userNumbers = listOf<Int>()
    private val numberCount = 3

    init {
        printStartMessage()
    }

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    fun runGame() {
        randomNumbers = randomlyGeneratedNumbers()
        userNumbers = userEnteredNumbers()
    }

    private fun randomlyGeneratedNumbers(): List<Int> {
        val count = numberCount
        val numbers = mutableListOf<Int>()

        for (i in 0..count) {
            val number = Random.nextInt(8) + 1   // 1 부터 9 사이의 난수
            numbers.add(number)
        }

        return numbers
    }

    private fun userEnteredNumbers(): List<Int> {
        val numbers = mutableListOf<Int>()
        val userInput = enteredInput()

        formatChangedNumbers(userInput).map { number -> numbers.add(number) }

        return numbers
    }

    private fun enteredInput(): String {
        val message = "숫자를 입력해주세요 : "

        print(message)
        return Console.readLine()
    }

    private fun formatChangedNumbers(input: String): List<Int> {
        checkNumbersCondition(input)
        return input.map { data -> Character.getNumericValue(data) }
    }

    private fun checkNumbersCondition(input: String) {
        checkNumberCountCondition(input)
        checkNumberFormatCondition(input)
        checkNumberRangeCondition(input)
    }

    private fun checkNumberCountCondition(input: String) {
        if (input.length != numberCount)
            throw IllegalArgumentException()
    }

    private fun checkNumberFormatCondition(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false))
            throw IllegalArgumentException()
    }

    private fun checkNumberRangeCondition(input: String) {
        if (input.map { data -> Character.getNumericValue(data) in 1..9 }.contains(false))
            throw IllegalArgumentException()
    }
}