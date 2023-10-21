package baseball.data

import camp.nextstep.edu.missionutils.Randoms

data class GameNumDeck(
    val nums: List<Int>,
) {
    companion object {
        const val DIGIT = 3

        fun generateRandomDeck(): GameNumDeck {
            val tempNumSet = mutableSetOf<Int>()
            while (tempNumSet.size < DIGIT) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                tempNumSet.add(randomNumber)
            }
            return GameNumDeck(tempNumSet.toList())
        }
    }
}