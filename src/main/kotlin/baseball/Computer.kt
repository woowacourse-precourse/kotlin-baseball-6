package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun getNumberList(): MutableList<Int> {
        val mutableList = mutableListOf<Int>()
        while (mutableList.size < 3) {
            val element = Randoms.pickNumberInRange(1, 9)
            if (!mutableList.contains(element)) {
                mutableList.add(element)
            }
        }
        return mutableList
    }
}