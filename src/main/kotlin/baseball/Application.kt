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

    if (scores.isEmpty()) {
        println("낫싱")
    } else {
        println(
            "${removeCount(scores.count { it == BALL }, "볼")} ${removeCount(scores.count { it == STRIKE }, "스트라이크")}".trim()
        )
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

fun removeCount(count: Int, string: String) =
    if (count == 0) {
        ""
    } else {
        "$count$string"
    }