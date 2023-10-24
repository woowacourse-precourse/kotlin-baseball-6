package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = BaseballGame()
    game.gameStart()
}

class BaseballGame {
    private var targetNumbers = mutableListOf<Int>()

    /* 숫자 야구 게임 */
    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
        var restartGame = true

        while (restartGame) {
            targetNumbers.clear()
            /* 매 게임의 타겟 숫자 3개 선택 */
            for (i in 0..2)
                targetNumbers.add(Randoms.pickNumberInRange(1, 9))
            inputNumbers()

            // 게임 종료
            restartGame = inputRestart()
        }
    }

    /* 게임 도중 3스트라이크가 될 때까지 사용자로부터 3개의 숫자 입력을 받는 함수 */
    private fun inputNumbers() {
        var strike = 0
        var ball = 0
        
        while (strike != 3) {
            print("숫자를 입력해주세요: ")
            val inputNumbers = Console.readLine()

            /* 예외 처리 */
            if (inputNumbers.length != 3)
                throw IllegalArgumentException("길이가 3이 아닌 입력 발생")
            if (inputNumbers.toIntOrNull() == null)
                throw IllegalArgumentException("숫자가 아닌 입력 발생")
            if ('0' in inputNumbers)
                throw IllegalArgumentException("범위를 벗어난 숫자 입력 발생")

            val result = checkNumbers(inputNumbers)
            strike = result[0]
            ball = result[1]

            outputResult(strike, ball)
        }
    }

    /* 게임 도중 사용자로부터 입력받은 3개의 수에 대해 스트라이크, 볼을 판단하는 함수 */
    private fun checkNumbers(inputString: String): List<Int> {
        var strike = 0
        var ball = 0

        for (i in 0..2) {
            val check = inputString[i].digitToInt()
            if (check == targetNumbers[i])
                strike++
            else if (check in targetNumbers)
                ball++
        }

        return listOf(strike, ball)
    }

    /* checkNumbers 함수로 판단한 스트라이크, 볼을 형식에 맞게 출력하는 함수 */
    private fun outputResult(strike: Int, ball: Int) {
        if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else if (strike == 0 && ball != 0) {
            println("${ball}볼")
        } else if (strike != 0 && ball == 0) {
            println("${strike}스트라이크")
        } else if (strike != 0 && ball != 0) {
            println("${ball}볼 ${strike}스트라이크")
        } else {
            println("낫싱")
        }
    }

    /* 게임 종료 후 재시작 또는 종료를 위한 입력을 받는 함수 */
    private fun inputRestart(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
        val inputAfterGameOver = Console.readLine()

        /* 예외 처리 */
        if (inputAfterGameOver != "1" && inputAfterGameOver != "2")
            throw IllegalArgumentException("1, 2 이외의 다른 입력 발생")

        return when (inputAfterGameOver.toInt()) {
            1 -> true
            else -> false
        }
    }
}