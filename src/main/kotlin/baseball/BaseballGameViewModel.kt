package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballGameViewModel(private val model: BaseballGameModel, private val view: BaseballGameView) {
    private fun startGame() {
        model.startNewGame()
        view.displayStartGameMessage()
        model.answer = generateRandomNumber()
    }

    fun gameRun() {
        do {
            playGame()
        } while (view.chooseRestartAndExit())
    }

    private fun playGame() {
        startGame()
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
            if (userNumber[idx] == answer[idx]) {
                strike++
                continue
            }
            if (userNumber.contains(answer[idx])) {
                ball++
            }
        }

        return Pair(strike, ball)
    }

}
