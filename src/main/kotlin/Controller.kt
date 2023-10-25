import computer.Computer
import view.OutputView

class Controller(
    private val computer: Computer,
) {
    fun beginOfBaseballGame() {
        OutputView.startBaseballGame()
    }

    fun setComputerNumber() {
        computer.setRandomBaseballNumber()
    }
}

