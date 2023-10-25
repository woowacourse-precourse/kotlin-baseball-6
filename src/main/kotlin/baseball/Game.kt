package baseball

import camp.nextstep.edu.missionutils.Console

class Game constructor(
    private val gamePrint: GamePrint = GamePrint()
) {

    fun startGame() {
        while (true) {
            gamePrint.startGamePrint()
            inGame()
            gamePrint.gameOptionPrint()

        }
    }

    private fun inGame() {
        val randomNumber = Computer().randomNumbers
        while (true) {

            gamePrint.inputUserPrint()
            val userNumber = Console.readLine().map {
                it.digitToInt()
            }.toList()

            val result: Result = checkNumbers(userNumber, randomNumber)
            gamePrint.resultPrint(result)

        }
    }

    private fun checkNumbers(
        userNumber: List<Int>, randomNumber: List<Int>
    ): Result {

        var ballCount = 0
        var strikeCount = 0

        // 스트라이크 갯수를 세는 for문
        for (i in userNumber.indices) {
            if (userNumber[i] == randomNumber[i]) {
                strikeCount++
            }
        }

        // 볼 갯수를 세는 for문
        for (i in userNumber.indices) {
            if (userNumber[i] != randomNumber[i]) {
                if (randomNumber.contains(userNumber[i])) {
                    ballCount++
                }
            }
        }

        return Result(strikeCount = strikeCount, ballCount = ballCount)
    }

}