package baseball

import Controller
import baseballnumbercomparator.BaseballNumberComparator
import baseballnumbercomparator.BaseballNumberComparatorImpl
import computer.Computer
import computer.ComputerImpl
import player.Player
import player.PlayerImpl
import randombaseballnumbergenerator.RandomBaseballNumberGenerator
import randombaseballnumbergenerator.RandomBaseballNumberGeneratorImpl

fun main() {
    val baseballNumberComparator: BaseballNumberComparator = BaseballNumberComparatorImpl
    val randomBaseballNumberGenerator: RandomBaseballNumberGenerator = RandomBaseballNumberGeneratorImpl
    val computer: Computer = ComputerImpl(randomBaseballNumberGenerator)
    val player: Player = PlayerImpl()
    val controller = Controller(
        baseballNumberComparator,
        computer,
        player
    )

    controller.beginOfBaseballGame()
    controller.setComputerNumber()

    while (true) {
        controller.inputBaseballNumber()
        val baseballResult = controller.compareAnswerAndBaseballNumber()

        if (baseballResult.strike == Controller.THREE_STRIKE) {
            controller.showIntermediateResult(baseballResult)
            controller.threeStrike()
            if (controller.inputRestartOrTerminate() == Controller.TERMINATE) {
                break
            }
            controller.setComputerNumber()
        } else {
            controller.showIntermediateResult(baseballResult)
        }
    }
}
