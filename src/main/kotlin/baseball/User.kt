package baseball

import camp.nextstep.edu.missionutils.Console

class User : Player<List<Int>> {
    fun inputNumber(): String {
        return Console.readLine()
    }

    fun requestInputGameState(): Int {
        val input = Console.readLine()
        Validator.validateInputGameState(input)
        Console.close()

        return input.toInt()
    }

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String): List<Int> {
        Validator.validateInput(input)

        val numbers = input.map { it.toString().toInt() }
        Validator.validateNumbers(numbers)

        return numbers
    }
}