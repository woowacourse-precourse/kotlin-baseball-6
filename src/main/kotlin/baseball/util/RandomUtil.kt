package baseball.util

import camp.nextstep.edu.missionutils.Randoms

object RandomUtil {

    //random한 정답 숫자배열 생성
    fun getRandomNumbers(): MutableList<Int> {
        val randNumList = mutableListOf<Int>()

        while (randNumList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randNumList.contains(randomNumber)) {
                randNumList.add(randomNumber)
            }
        }

        return randNumList
    }
}