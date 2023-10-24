package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class RandomGenerator {
    init {
        println("${RandomNum()}")
    }
    private fun RandomNum(): List<Int>{
        val computer: MutableList<Int> = mutableListOf()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.toList()
    }
}