package baseball.controller

import baseball.domain.ComputerNumberGenerator
import baseball.domain.Referee
import baseball.domain.model.Computer
import baseball.domain.model.Player
import baseball.presentation.InputView
import baseball.presentation.OutputView

class BaseBallGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun play() {
        outputView.printStart()
        do {
            val computer = createComputer()
            println(computer)
            do {
                val player = createPlayer()
                val referee = Referee(player, computer)
                val result = referee.judge()
                outputView.printResult(result)
            } while (result.strike != 3)
            outputView.printEnd()
            val reGameOrQuitProgram = inputView.readReGameOrQuitProgram().toInt()
        } while (reGameOrQuitProgram == 1)
    }

    private fun createPlayer(): Player =
        try {
            val playerNumber = inputView.readPlayerNumber().map { it.toString().toInt() }
            Player(playerNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            createPlayer()
        }

    private fun createComputer(): Computer =
        try {
            val computerNumber = ComputerNumberGenerator.generate()
            Computer(computerNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            createComputer()
        }
}