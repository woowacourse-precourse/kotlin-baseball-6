package baseball

import camp.nextstep.edu.missionutils.Console

class User : Player<List<Int>> {
    /**
     * 사용자에게 게임 진행 여부를 입력받고 유효한 게임 상태 정수 반환
     */
    fun requestInputGameState(): Int {
        val input = Console.readLine()

        return parseGameStateInput(input)
    }

    /**
     * 입렫된 문자열에 대해 유효성 검사 후 정수로 변환하여 반환
     */
    private fun parseGameStateInput(input: String): Int {
        Validator.validateInput(input)

        val gameState = input.toInt()
        Validator.validateInputGameState(gameState)

        return gameState
    }

    /**
     * 사용자에게 숫자 문자열을 입력받고 유효한 숫자 리스트 반환
     */
    fun requestInputNumbers(): List<Int> {
        val input = Console.readLine()

        return generateNumbers(input)
    }

    /**
     * 입력된 숫자 문자열에 대해 유효성 검사 후 숫자 리스트로 변환하여 반환
     */
    override fun generateNumbers(input: String): List<Int> {
        Validator.validateInput(input)

        val numbers = input.map { it.toString().toInt() }
        Validator.validateNumbers(numbers)

        return numbers
    }

    /**
     * 입력을 종료하고 입력스트림 닫기
     */
    fun requestEndInput() {
        Console.close()
    }
}