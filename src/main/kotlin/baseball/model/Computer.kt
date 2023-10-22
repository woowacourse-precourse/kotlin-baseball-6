package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun makeComputerList(): BaseBall {
        val computerList = mutableListOf<Int>()
        while (computerList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber)
            }
        }
        return BaseBall(computerList)
    }
}