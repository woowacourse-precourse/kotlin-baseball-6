package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberGenerator : NumberProvider {

    private var numberList = generateRandomNumberList()

    override fun getNumberList() = numberList

    private fun generateRandomNumberList(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        while (numberSet.size < MAX_SIZE) {
            numberSet.add(pickNumberInRange(START, END))
        }
        return numberSet.toList()
    }

    companion object {
        private const val START = 1
        private const val END = 9
        private const val MAX_SIZE = 3
    }
}
