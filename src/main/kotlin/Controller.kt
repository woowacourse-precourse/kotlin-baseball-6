import baseballnumbercomparator.BaseballNumberComparator
import baseballnumbercomparator.BaseballResult
import computer.Computer
import player.Player
import validator.baseballnumbervalidator.BaseballNumberValidatorImpl
import validator.gamecontrolvalidator.GameControlValidatorImpl
import view.InputView
import view.OutputView

class Controller(
    private val baseballNumberComparator: BaseballNumberComparator,
    private val computer: Computer,
    private val player: Player,
) {
    fun beginOfBaseballGame() {
        OutputView.startBaseballGame()
    }

    fun setComputerNumber() {
        computer.setRandomBaseballNumber()
    }

    fun inputBaseballNumber() {
        OutputView.pleaseInputBaseballNumber()
        val responseRandomBaseballNumber = InputView.askBaseballNumber(BaseballNumberValidatorImpl)
        player.setBaseballNumber(responseRandomBaseballNumber)
    }

    fun compareAnswerAndBaseballNumber(): BaseballResult {
        return baseballNumberComparator.compareAnswerWithPlayerBaseballNumber(
            computer.randomBaseballNumber,
            player.baseballNumber
        )
    }

    fun threeStrike() {
        OutputView.guessedAllBaseballNumber()
        OutputView.restartOrTerminateGame()
    }

    fun showIntermediateResult(baseballResult: BaseballResult) {
        OutputView.intermediateResult(baseballResult.strike, baseballResult.ball)
    }

    fun inputRestartOrTerminate(): String {
        return InputView.inputReStartOrExit(GameControlValidatorImpl)
    }

    companion object {
        const val THREE_STRIKE = 3
        const val TERMINATE = "2"
    }
}

