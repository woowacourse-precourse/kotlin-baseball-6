package baseball.model

import baseball.BASEBALL_DIGITS
import camp.nextstep.edu.missionutils.Randoms

// TODO : newGenerator()를 일부에서만 접근할 수 있는 방법 학습하고 적용
class Answer {
    private var _number: IntArray = answerGenerator()

    val number: IntArray get() = _number

    internal fun newGenerator() {
        _number = answerGenerator()
        println("정답 : ${number.contentToString()}") // TODO For Debuging
    }
}

/** [1]. 1..9에서 서로 다른 N개의 수 뽑기 (Model) */
fun answerGenerator(): IntArray {
    val computer = mutableListOf<Int>()

    while (computer.size < BASEBALL_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toIntArray()
}

