package baseball.model

import baseball.BASEBALL_DIGITS
import camp.nextstep.edu.missionutils.Randoms

/** [1]. 1..9에서 서로 다른 N개의 수 뽑기 (Model) */
fun answerSelect(): IntArray {
    val computer = mutableListOf<Int>()

    while (computer.size < BASEBALL_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toIntArray()
}