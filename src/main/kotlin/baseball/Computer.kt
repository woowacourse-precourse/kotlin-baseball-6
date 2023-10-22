package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer = mutableListOf<Int>()
    init {
        answer.add(Randoms.pickNumberInRange(1, 9))
        this.createAnswer()
    }
    private fun createAnswer() {
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }

}