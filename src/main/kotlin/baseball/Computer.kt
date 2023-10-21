package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    override fun generateNumbers() {
        val generatedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)
        println(generatedNumbers)

        if (Validator.areInvalidCountNumbers(generatedNumbers)) {
            throw IllegalArgumentException("수의 개수가 올바르지 않습니다.")
        }

        if (Validator.areOutOfRangeNumbers(generatedNumbers)) {
            throw IllegalArgumentException("수의 범위가 잘못되었습니다.")
        }

        if (Validator.areDuplicateNumbers(generatedNumbers)) {
            throw IllegalArgumentException("중복된 수가 있습니다.")
        }

        numbers = generatedNumbers
    }
}