package baseball

import baseball.domain.GameProcessor
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val numberSize = 3
    while (true) {
        InputView.printGameStartMessage()
        val gameProcessor = GameProcessor()
        val isRestart = gameProcessor.startGameProcess(numberSize)
        OutputView.printGameEndMessage(numberSize)
        if (!isRestart) break
    }
}
