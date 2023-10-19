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

    private fun countStrikes(other: BaseballNumber): Int {
        var strikes = 0
        for (i in 0..<NUMBER_SIZE) {
            if (other.numbers[i] == this.numbers[i]) {
                ++strikes
            }
        }
        return strikes
    }

    private fun countBalls(other: BaseballNumber): Int {
        var balls = 0
        numbers.forEachIndexed { index, number ->
            val otherNumbers = other.numbers
            val containsNumber = otherNumbers.contains(number)
            val sameIndex = otherNumbers[index] == number
            if (containsNumber && !sameIndex) {
                ++balls
            }
        }
        return balls
    }

    fun judge(other: BaseballNumber): JudgeResult {
        return JudgeResult(
            balls = countBalls(other),
            strikes = countStrikes(other)
        )
    }

    companion object {
        const val NUMBER_SIZE = 3
    }
}
