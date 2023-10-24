package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var userInput = ""
var userNumber = 0
var int_one = 0
var int_two = 0
var int_three = 0
const val NUMBER_SIZE = 3


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer = getRandomNumbers()
    
}

fun getRandomNumbers(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < NUMBER_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

