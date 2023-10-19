package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballEngine {
    /**
     * 중복 비허용
     */
    fun generateRandomNumber(): BaseballNum {
        val numbers = getRandomList()
        return BaseballNum(numbers[0], numbers[1], numbers[2])
    }

    // TODO pickNumberInRange 구현해보기
    private fun getRandomList(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3)
    }

    fun compare(computer: BaseballNum, user: BaseballNum): BaseballResult {
        TODO()
    }
}