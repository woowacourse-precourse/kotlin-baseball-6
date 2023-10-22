package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }
}