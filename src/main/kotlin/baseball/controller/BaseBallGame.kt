package baseball.controller

import baseball.domain.Referee
import baseball.domain.model.Computer
import baseball.domain.model.Player
import baseball.presentation.InputView
import baseball.presentation.OutputView
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    init {
        play()
    }

    private fun play() {
        outputView.printStart()

        val computer = createComputer()
        println(computer)

        do {
            val player = createPlayer()
            val referee = Referee(player, computer)

            val result = referee.judge()
            println("${result.strike} ${result.ball} ${result.nothing}")
        } while (result.strike != 3)

        outputView.printEnd()
    }

    private fun createPlayer(): Player =
        try {
            val playerNumber = inputView.readPlayerNumber().map { it.toString().toInt() }
            Player(playerNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            createPlayer()
        }

    private fun createComputer(): Computer {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return Computer(computer)
    }
}