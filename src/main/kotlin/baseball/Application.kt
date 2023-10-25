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

    do {
        val userNum = inputView.userInputNum()

        if (gameService.startGame(userNum)) {
            if (!resultView.askForRestart()) break
        }

        gameService.restart()
    } while (true)
}
