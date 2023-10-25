package baseball

import baseball.domain.Computer
import baseball.service.GameService
import baseball.view.InputView
import baseball.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val gameService = GameService(Computer())

    resultView.printStartMessage()

    playGame(inputView, resultView, gameService)
}

fun playGame(inputView: InputView, resultView: ResultView, gameService: GameService) {
    val userNum = inputView.getUserInputNum()

    if (gameService.startGame(userNum)) {
        if (!resultView.askForRestart()) {
            return
        }

        gameService.restartGame()
    }

    playGame(inputView, resultView, gameService)
}
