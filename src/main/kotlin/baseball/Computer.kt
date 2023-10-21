package baseball

import camp.nextstep.edu.missionutils.Randoms

const val START_NUMBER = 1
const val END_NUMBER = 9
const val NUMBER_COUNT = 3

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    override fun generateNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)

        if (areInvalidCountNumbers(numbers)) {
            throw IllegalArgumentException("수의 개수가 올바르지 않습니다.")
        }

        if (areOutOfRangeNumbers(numbers)) {
            throw IllegalArgumentException("수의 범위가 잘못되었습니다.")
        }

        if (areDuplicateNumbers(numbers)) {
            throw IllegalArgumentException("중복된 수가 있습니다.")
        }
    }

    private fun areInvalidCountNumbers(numbers: List<Int>): Boolean {
        return numbers.size == NUMBER_COUNT
    }

    private fun areOutOfRangeNumbers(numbers: List<Int>): Boolean {
        return numbers.all { it in START_NUMBER..END_NUMBER }
    }

    private fun areDuplicateNumbers(numbers: List<Int>): Boolean {
        val distinctNumbers = numbers.toSet()
        return numbers.size == distinctNumbers.size
    }
}