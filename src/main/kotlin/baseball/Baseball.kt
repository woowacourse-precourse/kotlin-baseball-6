package baseball

import kotlin.random.Random

class Baseball {
    private var randomNumbers = listOf<Int>()

    init {
        printStartMessage()
    }

    fun runGame() {
        randomNumbers = randomlyGeneratedNumbers()
    }

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    private fun randomlyGeneratedNumbers(): List<Int> {
        val count = 3
        val numbers = mutableListOf<Int>()

        for (i in 0..count) {
            val number = Random.nextInt(8) + 1   // 1 부터 9 사이의 난수
            numbers.add(number)
        }

        return numbers
    }
}