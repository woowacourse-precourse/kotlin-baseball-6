package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    // 컴퓨터 숫자 랜덤 초기화(중복 제외) - GameManager class의 initComputer()에서 호출
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