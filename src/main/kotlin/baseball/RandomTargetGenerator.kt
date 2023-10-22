package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomTargetGenerator {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 9
        private const val TARGET_SIZE = 3
    }

    fun generateRandomTarget() : List<Int> {
        val target = mutableListOf<Int>()

        while (target.size < TARGET_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            if (!target.contains(randomNumber)) {
                target.add(randomNumber)
            }
        }
        return target.toList()
    }
}