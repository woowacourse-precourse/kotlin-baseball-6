package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : "


fun main() {
    TODO("프로그램 구현")
}

fun generateRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun userInput(): List<Int> {
    println(INPUT_NUMBER_MESSAGE)
    val userNumber = Console.readLine().map {it.digitToInt()}

    if(userNumber.contains(0)) {
        throw IllegalArgumentException("1~9 사이의 값을 입력해주세요")
    }
    if(userNumber.size != 3) {
        throw IllegalArgumentException("3자리 수를 입력해주세요")
    }
    if(userNumber.) {
        throw IllegalArgumentException("중복 되지 않는 숫자를 입력해주세요")
    }

    return userNumber
}

fun game(computer: List<Int>, userNumber: List<Int>): MutableList<Int>{
    var ballCount: Int = 0
    var strikeCount: Int = 0

    for (i in computer.indices) {
        if (computer[i] == userNumber[i]) {
            strikeCount++
        }
        else{ // if (computer.contains(userNumber))
            ballCount++
        }
    }

    return listOf(ballCount,strikeCount)
}
