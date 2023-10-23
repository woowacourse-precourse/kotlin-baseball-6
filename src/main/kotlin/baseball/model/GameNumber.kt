package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class GameNumber {

    // 서로 다른 수로 이루어진 3자리 수 생성
    fun createNum() : String {
        val computer = mutableListOf<String>()
        computer.clear()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber.toString())) {
                computer.add(randomNumber.toString())
            }
        }

        val answer = computer.joinToString("")

        return answer
    }
}