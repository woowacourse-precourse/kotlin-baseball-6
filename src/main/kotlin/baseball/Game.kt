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
            val userInput = Console.readLine()
            throwsUserOptionNumberInputError(userInput)

            if (userInput.toInt() == 2) break
        }
    }

    private fun inGame() {
        val randomNumber = Computer.createRandomNumbers()
        while (true) {

            gamePrint.inputUserPrint()
            val userInput = Console.readLine()
            throwsUserGameNumberInputError(userInput)
            val userNumber = userInput.map {
                it.digitToInt()
            }.toList()

            val result: Result = checkNumbers(userNumber, randomNumber)
            gamePrint.resultPrint(result)
            if (result.userSuccess) {
                break;
            }
        }
        gamePrint.endGamePrint()
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

    private fun throwsUserGameNumberInputError(userInput: String) {
        // 입력 값이 3자리가 아닐 경우 체크
        require(userInput.length == 3)

        // 입력 값이 숫자가 아닐 경우 체크
        userInput.forEach { i ->
            require(i.isDigit())
            require(i != '0')
        }

        // 입력 값 내에 중복 숫자가 있는 체크
        val hashSet = hashSetOf<Char>()
        userInput.forEach { i ->
            require(!hashSet.contains(i))
            hashSet.add(i)
        }

    }

    private fun throwsUserOptionNumberInputError(userInput: String) {
        // 입력받은 값이 1과 2가 아닐경우 체크
        require(userInput.toInt() == 1 || userInput.toInt() == 2)
    }

}