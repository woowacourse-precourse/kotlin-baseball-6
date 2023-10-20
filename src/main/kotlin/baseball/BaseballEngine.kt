package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballEngine {
    fun generateRandomNumber(): BaseballNum {
        val numbers = getRandomList()
        return BaseballNum(numbers[0], numbers[1], numbers[2])
    }

    private fun getRandomList(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    fun compare(computer: BaseballNum, user: BaseballNum): BaseballResult {
        TODO()
    }
}