package baseball

import camp.nextstep.edu.missionutils.Console

class User : Player<List<Int>> {

    fun requestInputGameState(): Int {
        val input = Console.readLine()
        Validator.validateInputGameState(input)

        return input.toInt()
    }

    fun requestEndInput() {
        Console.close()
    }

    fun requestInputNumbers(): String {
        val input = Console.readLine()
        Validator.validateInput(input)

        return input
    }

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String): List<Int> {
        val numbers = input.map { it.toString().toInt() }
        Validator.validateNumbers(numbers)

        return numbers
    }
}