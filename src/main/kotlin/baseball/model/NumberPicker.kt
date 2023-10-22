package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class NumberPicker {
    fun pickRandomNumber(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.toList()
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 9
    }
}
