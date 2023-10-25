package baseball

import baseball.Constant.INPUT_PLAYER_NUMBER_MESSAGE
import baseball.Constant.INPUT_PLAYER_RESTART_OR_FINISH_MESSAGE
import baseball.Constant.NUMBER_LENGTH
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    private val computerNumbers = mutableSetOf<Int>()

    fun setNumber() {
        computerNumbers.clear()
        while (computerNumbers.size < NUMBER_LENGTH) {
            val selectNumber = Randoms.pickNumberInRange(1, 9)
            computerNumbers.add(selectNumber)
        }
    }

    fun getNumber() = computerNumbers.toList()

    fun askNumber() {
        print(INPUT_PLAYER_NUMBER_MESSAGE)
    }

    fun askRestartOrFinish() {
        println(INPUT_PLAYER_RESTART_OR_FINISH_MESSAGE)
    }
}