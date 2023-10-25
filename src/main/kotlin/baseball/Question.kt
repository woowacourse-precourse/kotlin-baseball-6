package baseball

import camp.nextstep.edu.missionutils.Randoms

class Question {
    private val computerEmpty = emptyList<Int>()
    private val computer = computerEmpty.toMutableList()
    fun makeThreeNumbers(): String {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }
}