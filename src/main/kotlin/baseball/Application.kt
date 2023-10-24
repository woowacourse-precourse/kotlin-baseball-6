package baseball

import camp.nextstep.edu.missionutils.Randoms
import baseball.Score.*

enum class Score {
    STRIKE, BALL, FOUL
}

fun main() {
    var number = getRandomNumber()

    print("숫자를 입력해주세요 : ")
    val inputInt: List<Int> = readLine()!!.toList().map { it.digitToInt() }

    if (inputInt.size != number.size) {
        throw IllegalArgumentException()
    }

    val scores = mutableListOf<Score>()

    number.forEachIndexed { index, it ->
        if (it == inputInt[index]) {
            scores.add(STRIKE)
        } else if (inputInt.contains(it)) {
            scores.add(BALL)
        }
    }


}

fun getRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}