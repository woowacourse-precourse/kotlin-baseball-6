package baseball.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    fun generate(start: Int, end: Int, size: Int): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < size) {
            val randomNumber = Randoms.pickNumberInRange(start, end)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}