package baseball.game

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class BaseballGame(val digits: Int = 3) {
    val name = "숫자 야구 게임"
    fun start() {
        println("${name}을 시작합니다.")
        val answer: List<Int> = generateRandomAnswer(digits)
    }

    private fun generateRandomAnswer(digits: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < digits) {
            val num = pickNumberInRange(1, 9)
            if (num !in numbers) {
                numbers.add(num)
            }
        }
        return numbers
    }
}