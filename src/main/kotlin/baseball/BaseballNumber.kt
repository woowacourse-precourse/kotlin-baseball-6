package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballNumber private constructor(
    private val numbers: List<Int>
) {
    companion object {

        const val NUMBER_SIZE = 3

        fun random(): BaseballNumber {
            val numbers = mutableListOf<Int>()
            while (numbers.size < NUMBER_SIZE) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber)
                }
            }
            return BaseballNumber(numbers)
        }

        fun createOrThrow(input: String): BaseballNumber {
            require(input.length == NUMBER_SIZE)
            requireUnique(input)
            requireOnlyDigit(input)
            val numbers = input.map { it.digitToInt() }
            return BaseballNumber(numbers)
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
    }

    private fun countStrikes(other: BaseballNumber): Int {
        var strikes = 0
        repeat(NUMBER_SIZE) { i ->
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
}
