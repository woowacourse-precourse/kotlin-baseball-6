package baseball

import camp.nextstep.edu.missionutils.Randoms

class GameProgram {

    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")

        val computerNumbers = createRandomNumbers()
    }

    private fun createRandomNumbers():List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < 3) {
            val number = Randoms.pickNumberInRange(1,9)
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
        return randomNumbers
    }
}