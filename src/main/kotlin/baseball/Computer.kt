package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val randomNumbers: List<Int>

    init {
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    }
}