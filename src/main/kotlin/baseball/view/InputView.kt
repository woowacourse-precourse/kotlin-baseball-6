package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputBallNumbers(): List<Int> {
        if (executionCount++ == 0) {
            println("숫자 야구 게임을 시작합니다.")
        }
        println("숫자를 입력해주세요 : ")

        return readLine()
                .split("")
                .map { it.toInt() }
    }

    fun inputWillReplay(): Boolean {
        print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val input = readLine()

        return when (input) {
            "1" -> true
            "2" -> false
            else -> throw IllegalArgumentException("1, 2 중 하나를 입력해주세요.")
        }
    }

    private fun readLine() =
            Console.readLine().trim()

    companion object {
        private var executionCount = 0
    }

}