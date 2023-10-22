package baseball.view

import baseball.domain.BallNumber
import baseball.domain.GameStatus
import camp.nextstep.edu.missionutils.Console

class InputView(private val inputValidator: InputValidator) {

    fun inputBallNumbers(): List<BallNumber> {
        if (executionCount++ == 0) {
            println("숫자 야구 게임을 시작합니다.")
        }
        print("숫자를 입력해주세요 : ")

        val input = readLine()
        // 입력 받은 값이 null이 아니며 숫자로 이루어진 문자열인지 검증
        inputValidator.validateNumbersInput(input)

        return input
            .map { it.toString().toInt() }
            .map { BallNumber(it) }
    }

    fun inputNextGameStatus(): GameStatus {
        println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val status = GameStatus.of(readLine())

        // 사용자가 잘못된 입력을 한 경우,
        // 다시 입력 받도록 함
        if (GameStatus.UNKNOWN == status) {
            // 경고 메세지를 출력하여 사용자의 올바른 입력을 유도
            println("잘못된 입력입니다. 반드시 1, 2 중 하나를 입력해야 합니다.")
            // 올바르지 않은 입력인 경우 올바른 입력을 할 때까지 재귀 호출하여 올바른 입력 반환
            return inputNextGameStatus()
        }
        // 올바른 입력인 경우 그대로 반환
        return status
    }

    private fun readLine() =
        Console.readLine().trim()

    companion object {
        private var executionCount = 0
    }

}