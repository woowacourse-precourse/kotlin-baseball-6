package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Number {

    // 서로 다른 수로 이루어진 3자리 수 생성
    fun createNum() : Int {
        val computer = mutableListOf<String>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber.toString())) {
                computer.add(randomNumber.toString())
            }
        }

        val answer = computer.joinToString("").toInt()

        return answer
    }
}