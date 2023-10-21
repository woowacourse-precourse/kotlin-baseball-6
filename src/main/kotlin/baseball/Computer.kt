package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String) {
        val generatedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)
        Validator.validateNumbers(generatedNumbers)
        numbers = generatedNumbers
    }
}