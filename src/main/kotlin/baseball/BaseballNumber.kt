package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballNumber {

    private val numbers: List<Int>

    constructor() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 9, NUMBER_SIZE)
    }

    constructor(numbers: String) {
        require(numbers.length == NUMBER_SIZE)
        requireUnique(numbers)
        requireOnlyDigit(numbers)
        this.numbers = numbers.map { it.code }
    }

    private fun requireOnlyDigit(numbers: String) {
        numbers.forEach { numberChar ->
            require(numberChar.isDigit()) { Messages.ContainsNonDigitChar }
        }
    }

    private fun requireUnique(numbers: String) {
        val hashSet = hashSetOf<Char>()
        numbers.forEach { numberChar ->
            require(!hashSet.contains(numberChar)) { Messages.DuplicatedNumber }
            hashSet.add(numberChar)
        }
    }

    companion object {
        private const val NUMBER_SIZE = 3
    }
}
