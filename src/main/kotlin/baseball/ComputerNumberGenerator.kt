package baseball

import baseball.NumberBounds.END_NUMBER
import baseball.NumberBounds.MAX_SIZE
import baseball.NumberBounds.START_NUMBER
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberGenerator : NumberProvider {

    private var numberList = generateRandomNumberList()

    override fun getNumberList() = numberList

    private fun generateRandomNumberList(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        while (numberSet.size < MAX_SIZE) {
            numberSet.add(pickNumberInRange(START_NUMBER, END_NUMBER))
        }
        return numberSet.toList()
    }
}
