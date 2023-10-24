package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object BaseballGame {

    private const val NUMBER_MATCH_COUNT = 3
    private const val GAME_OVER_MSG = "${NUMBER_MATCH_COUNT}스트라이크\n${NUMBER_MATCH_COUNT}개의 숫자를 모두 맞히셨습니다! 게임 종료"

    fun startGame() {
        val computerNumber = generateComputerNumber()

        while (true) {
            val result = compareWithUserInput(getUserInput(), computerNumber)
            println(result)
            if (result == GAME_OVER_MSG) break
        }
    }

    /** 1부터 9까지의 서로 다른 랜덤 숫자 뽑기 */
    private fun generateComputerNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < NUMBER_MATCH_COUNT) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
        return computerNumber
    }

    /** 사용자 숫자 입력받기 */
    private fun getUserInput(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine()?.map { it.toString().toIntOrNull() }

        if (userInput == null ||
            userInput.size != NUMBER_MATCH_COUNT ||
            userInput.toSet().size != NUMBER_MATCH_COUNT ||
            userInput.any { it !in 1..9 }
        ) {
            throw IllegalArgumentException()
        }

        return userInput.requireNoNulls()
    }

    /** 입력받은 숫자와 컴퓨터의 숫자를 비교하여 결과 반환 */
    private fun compareWithUserInput(userInput: List<Int>, computerNumber: List<Int>): String {
        var strikeCount = 0
        var ballCount = 0

        for (i in 0 until NUMBER_MATCH_COUNT) {
            if (userInput[i] == computerNumber[i]) {
                strikeCount++
            } else if (userInput[i] in computerNumber) {
                ballCount++
            }
        }

        return when {
            strikeCount == 3 -> GAME_OVER_MSG
            strikeCount > 0 && ballCount > 0 -> "${ballCount}볼 ${strikeCount}스트라이크"
            strikeCount > 0 -> "${strikeCount}스트라이크"
            ballCount > 0 -> "${ballCount}볼"
            else -> "낫싱"
        }
    }
}