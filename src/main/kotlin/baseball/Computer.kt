package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private var numbers: List<Int>? = null

    override fun generateNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    }
}