package baseball

import baseball.controller.BaseBallController
import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    val newGame = BaseBallController()
    newGame.play()
}
