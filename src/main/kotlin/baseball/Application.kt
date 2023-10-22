package baseball

import camp.nextstep.edu.missionutils.Randoms

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val NUMBER_LENGTH = 3
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9

var playingGame = true

fun main() {
    println(START_MESSAGE)
    while (playingGame) {
        val randomNum = createRandomNumber()
    }
}

private fun createRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < NUMBER_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}