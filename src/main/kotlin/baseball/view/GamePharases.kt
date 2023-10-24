package baseball.view

import baseball.model.input

const val START_PHR = "숫자 야구 게임을 시작합니다."
const val INPUT_NUM = "숫자를 입력해주세요 : "
const val CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val NOTHING = "낫싱"
const val BALL = "볼"
const val STRIKE = "스트라이크"
const val WRONG_INPUT = "잘못된 값 입력"

fun startGame() {
    println(START_PHR)
}

fun inputNum(): String {
    print(INPUT_NUM)
    return input()
}

fun correctAns() {
    println(CORRECT)
}

fun restart(): String {
    println(RESTART)
    return input()
}

fun showResult(nothing: Int, ball: Int, strike: Int) {
    if (nothing == 3) {
        println(NOTHING)
    }
    if (ball != 0 && strike != 0) {
        println("${ball}${BALL} ${strike}${STRIKE}")
    }
    if (ball == 0 && strike != 0) {
        println("${strike}${STRIKE}")
    }
    if (ball != 0 && strike == 0) {
        println("${ball}${BALL}")
    }
}
