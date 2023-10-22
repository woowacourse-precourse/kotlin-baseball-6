package baseball.model

import baseball.answerSelect

// TODO : newGenerator()를 일부에서만 접근할 수 있는 방법 학습하고 적용
class Answer {
    private var _number: IntArray = intArrayOf()

    init {
        newGenerator()
    }

    val number: IntArray get() = _number

    internal fun newGenerator() {
        _number = answerSelect()
        println("정답 : ${number.contentToString()}") // TODO For Debuging
    }
}