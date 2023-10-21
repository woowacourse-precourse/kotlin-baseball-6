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
        if (Validator.isInvalidNumericInput(input)) {
            throw IllegalArgumentException("숫자로만 입력해주세요.")
        }

        if (Validator.isBlankInput(input)) {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }

        val numbers = input.map { it.toString().toInt() }
        Validator.validateNumbers(numbers)

        return numbers
    }
}