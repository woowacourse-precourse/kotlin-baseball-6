package randombaseballnumbergenerator

import camp.nextstep.edu.missionutils.Randoms

object RandomBaseballNumberGeneratorImpl : RandomBaseballNumberGenerator {
    private const val RANDOM_BASEBALL_NUMBER_SIZE = 3
    private const val MINIMUM_BASEBALL_NUMBER = 1
    private const val MAXIMUM_BASEBALL_NUMBER = 9

    override fun generateRandomBaseballNumber(): String {
        val computer = mutableListOf<Int>()
        while (computer.size < RANDOM_BASEBALL_NUMBER_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MINIMUM_BASEBALL_NUMBER, MAXIMUM_BASEBALL_NUMBER)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }
}