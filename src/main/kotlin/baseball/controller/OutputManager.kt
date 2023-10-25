package baseball.controller

import baseball.domain.GameResult
import baseball.view.output.GameResultView
import io.Printer

class OutputManager(private val printer: Printer) {
    fun printResult(result: GameResult) {
        val gameResultView = GameResultView(result)
        printer.print(gameResultView)
    }
}