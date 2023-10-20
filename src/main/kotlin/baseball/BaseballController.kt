package baseball

import baseball.domain.BaseballGame
import baseball.presentation.InputView
import baseball.presentation.OutputView

class BaseballController(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView(), private val baseballGame: BaseballGame = BaseballGame()) {

    fun run() {
    }
}