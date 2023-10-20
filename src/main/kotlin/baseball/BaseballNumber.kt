package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballNumber {

    private val numbers: List<Int>

    constructor() {
        val numbers = mutableListOf<Int>()
        while (numbers.size < NUMBER_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        this.numbers = numbers
    }

    constructor(numbers: String) {
        require(numbers.length == NUMBER_SIZE)
        requireUnique(numbers)
        requireOnlyDigit(numbers)
        this.numbers = numbers.map { it.digitToInt() }
    }

    private fun requireOnlyDigit(numbers: String) {
        numbers.forEach { numberChar ->
            require(numberChar.isDigit()) { Messages.ContainsNonDigitChar }
            require(numberChar != '0') { Messages.ContainsZeroNumberDigit }
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

    override fun toString(): String {
        return numbers.joinToString()
    }

    companion object {
        const val NUMBER_SIZE = 3
    }
}
