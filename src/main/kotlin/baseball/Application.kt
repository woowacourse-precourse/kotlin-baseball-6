package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    private val computerNumbers = mutableListOf<Int>()

    fun generateComputer() {
        while (computerNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in computerNumbers) {
                computerNumbers.add(randomNumber)
            }
        }
    }
    fun getComputer(): List<Int> = computerNumbers
}

fun main() {

}