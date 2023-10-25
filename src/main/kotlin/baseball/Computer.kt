package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    val randomNumbers: List<Int>

    init {
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3)
        // 입력 값이 3자리가 아닐 경우 체크
        require(randomNumbers.size == 3)

        // 입력 값 내에 중복 숫자가 있는 체크
        val hashSet = hashSetOf<Int>()
        randomNumbers.forEach { randomNumber ->
            require(!hashSet.contains(randomNumber))
            hashSet.add(randomNumber)
        }
    }
}