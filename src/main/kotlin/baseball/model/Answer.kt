package baseball.model

import baseball.constants.GameConfig
import camp.nextstep.edu.missionutils.Randoms

class Answer {
    private var _number: IntArray = intArrayOf()

    init {
        newGenerator()
    }

    val number: IntArray get() = _number

    internal fun newGenerator() {
        _number = answerGenerator()
    }
}

/** [1]. 1..9에서 서로 다른 N개의 수 뽑기 (Model) */
fun answerGenerator(): IntArray {
    val computer = mutableListOf<Int>()
    while (computer.size < GameConfig.BASEBALL_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(
            GameConfig.BASEBALL_RANGE_FIRST, GameConfig.BASEBALL_RANGE_LAST,
        )
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toIntArray()
}