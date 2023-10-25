package baseball

class GameController {
    private val model = GameModel()
    private val view = GameView()

    fun run() {
        view.displayMessage("숫자 야구 게임을 시작합니다.")
        var playAgain = true

        while (playAgain) {
            val computerNumbers = model.generateComputerNumbers()
            var attempts = 0

            while (true) {
                val userGuess = view.getUserInput()
                val result = model.checkGuess(userGuess, computerNumbers)
                view.displayResult(result)
                attempts++

                if (result == "3스트라이크") {
                    view.displayGameWon()
                    break
                }
            }

            view.displayRestartOrExit()
            val choice = view.getUserInput()
            playAgain = choice == "1"

            if (playAgain) {
                view.displayMessage("새로운 게임을 시작합니다.")
            } else {
                view.displayMessage("게임을 종료합니다.")
            }
        }
    }
}
