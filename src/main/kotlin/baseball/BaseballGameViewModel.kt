package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballGameViewModel(private val model: BaseballGameModel, private val view: BaseballGameView) {
    private fun initializeGame() {
        model.startNewGame()
        view.displayStartGameMessage()
        model.answer = generateRandomNumber()
    }

    fun runGame() {
        do {
            playBaseball()
        } while (view.chooseRestartAndExit())
    }

    private fun playBaseball() {
        initializeGame()
        while (model.isGameRunning) {
            val userNumber = view.inputUserNumber()
            val score = compareWithNumber(model.answer, userNumber)
            view.printHint(score.first, score.second)
            if (score.first == 3) {
                view.gameOver()
                return
            }
        }
    }

    private fun generateRandomNumber(): String {
        val computer = mutableListOf<Int>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in computer) {
                computer.add(randomNumber)
            }
        }

        return computer.joinToString("")
    }

    private fun compareWithNumber(answer: String, userNumber: String): Pair<Int, Int> {
        var strike = 0
        var ball = 0

        for (idx in userNumber.indices) {
            if (userNumber[idx] == answer[idx]) { // 자리와 숫자 모두 동일한 경우
                strike++
                continue
            }
            if (userNumber.contains(answer[idx])) { // 숫자만 포함된 경우
                ball++
            }
        }

        return Pair(strike, ball)
    }
}
