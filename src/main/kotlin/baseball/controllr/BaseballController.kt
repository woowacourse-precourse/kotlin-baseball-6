package baseball.controllr

import baseball.model.BaseballModel
import baseball.view.BaseballView
import camp.nextstep.edu.missionutils.Console

class BaseballController(private val model: BaseballModel, private val view: BaseballView) {

    fun startGame() {
        view.showStartMessage()

        var isGameEnd = false

        while (!isGameEnd) {
            model.generateComputerNumbers()

            var isRoundEnd = false

            while (!isRoundEnd) {
                val userInput = view.getUserInput()
                val result = model.checkUserGuess(userInput)
                view.showResult(result)

                if (result.contains("3스트라이크")) {
                    val restart = Console.readLine()
                    isRoundEnd = true
                    isGameEnd = restart != "1"
                }
            }
        }
        view.showEndGameMessage()
    }

}