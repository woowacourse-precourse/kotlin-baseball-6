package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballNumber {

    private val numbers: List<Int>

    constructor() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 9, NUMBER_SIZE)
    }

    constructor(numbers: String) {
        this.numbers = numbers.map { it.code }
    }

    companion object {
        private const val NUMBER_SIZE = 3
    }
}
