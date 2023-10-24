package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer() {
    val randomBalls = makeRandomBallNumber()

    private fun makeRandomBallNumber(): List<Int> {
        val balls = mutableListOf<Int>()

        while (balls.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber)
            }
        }
        return balls
    }
}