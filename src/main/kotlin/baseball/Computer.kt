package baseball

import camp.nextstep.edu.missionutils.Randoms

object Computer {
    fun getAnswer(): MutableList<Int> {
        val answer = mutableListOf<Int>()
        while (answer.size < 3) {
            val randomNum = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNum)) {
                answer.add(randomNum)
            }
        }

        return answer
    }
}