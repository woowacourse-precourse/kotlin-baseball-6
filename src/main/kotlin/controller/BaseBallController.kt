package controller

import model.BaseballGame
import view.InputView
import view.OutputView

class BaseBallController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun gameRun(){
        outputView.printGameStartMessage()
        do {
            programRun()
            val isRetry = inputView.readIsRetry()
        } while (isRetry)
    }


    private fun programRun(){
        val baseballGame = BaseballGame()
        while (true){
            val userInput = inputView.readNumbers()
            val ball = baseballGame.getBallAmount(userInput)
            val strike = baseballGame.getStrikeAmount(userInput)
            outputView.printGameResult(ball,strike)
            if (strike==3) {
                outputView.printGameEndMessage()
                break
            }
        }
    }
}