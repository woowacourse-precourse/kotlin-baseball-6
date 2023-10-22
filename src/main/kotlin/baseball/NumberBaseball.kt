package baseball

import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3

    private val numList: ArrayList<Int> = arrayListOf<Int>()

    fun test() {
        println(numList)
    }

    fun initRandomNumbers(): NumberBaseball {
        while (numList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numList.contains(randomNumber)) numList.add(randomNumber)
        }
        return this
    }
}