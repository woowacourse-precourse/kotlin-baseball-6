package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {
    fun generateRandomNumber() {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
}