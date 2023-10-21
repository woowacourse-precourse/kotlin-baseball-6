package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomTargetGenerator {
    fun generateRandomTarget() : List<Int> {
        val target = mutableListOf<Int>()

        while (target.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!target.contains(randomNumber)) {
                target.add(randomNumber)
            }
        }
        return target.toList()
    }
}