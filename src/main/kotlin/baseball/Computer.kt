package baseball

import camp.nextstep.edu.missionutils.Randoms

object Computer {
    private val computerNumbers = mutableSetOf<Int>()

    fun setNumber() {
        computerNumbers.clear()
        while(computerNumbers.size < 3) {
            val selectNumber = Randoms.pickNumberInRange(1,9)
            computerNumbers.add(selectNumber)
        }
    }

    fun getNumber() : List<Int> {
        return computerNumbers.toList()
    }
}