package baseball

import camp.nextstep.edu.missionutils.Randoms

class Opponent {
    private var ranNum = mutableListOf<Int>()

    fun generateNum() {
        while (ranNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!ranNum.contains(randomNumber)) {
                ranNum.add(randomNumber)
            }
        }
    }

    fun getNum(): MutableList<Int> {
        return ranNum
    }
}