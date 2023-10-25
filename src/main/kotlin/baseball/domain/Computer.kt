package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

private const val MAX_NUMLIST_SIZE = 3
private const val MIN_NUM = 1
private const val MAX_NUM = 9

class Computer() {
    val numList = mutableListOf<Int>()

    init {
        generateRandomNumber(numList)
    }

    private fun generateRandomNumber(numList: MutableList<Int>) {
        while (numList.size < MAX_NUMLIST_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM)
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber)
            }
        }
    }
}