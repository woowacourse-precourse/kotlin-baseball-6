package baseball

import camp.nextstep.edu.missionutils.Console

class User : Player<List<Int>> {
    fun inputNumber(): String {
        return Console.readLine()
    }

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @param testNumbers testNumbers 테스트 목적으로 제공된 정수 리스트 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String, testNumbers: List<Int>): List<Int> {
        val numbers = input.map { it.toString().toInt() }

        if (Validator.areInvalidCountNumbers(numbers)) {
            throw IllegalArgumentException("수의 개수가 올바르지 않습니다.")
        }

        if (Validator.areOutOfRangeNumbers(numbers)) {
            throw IllegalArgumentException("수의 범위가 잘못되었습니다.")
        }

        if (Validator.areDuplicateNumbers(numbers)) {
            throw IllegalArgumentException("중복된 수가 있습니다.")
        }

        return numbers
    }
}