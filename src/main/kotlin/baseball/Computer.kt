package baseball

import camp.nextstep.edu.missionutils.Randoms

object Computer {
    private val computerNumbers = mutableListOf<Int>()

    fun setNumber() {
        repeat(3) {
            val selectNumber = Randoms.pickNumberInRange(1,9)
            computerNumbers.add(selectNumber)
        }
    }
}