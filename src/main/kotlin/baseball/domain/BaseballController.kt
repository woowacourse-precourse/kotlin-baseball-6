package baseball.domain

import baseball.domain.BaseballGame
import baseball.model.GameStatus
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView(), private val baseballGame: BaseballGame = BaseballGame()) {

    fun run() {
    }
}