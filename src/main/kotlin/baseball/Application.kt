package baseball

import camp.nextstep.edu.missionutils.Randoms
import baseball.Score.*

enum class Score {
    STRIKE, BALL, FOUL
}

fun main() {
    var number = getRandomNumber()

    while (true) {
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

        if (scores.count { it == STRIKE } == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            val input = readlnOrNull()!!.toInt()

            if (input == 1) {
                number = getRandomNumber()
            } else if (input == 2) {
                break
            } else {
                throw IllegalArgumentException()
            }
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

fun removeCount(count: Int, string: String) =
    if (count == 0) {
        ""
    } else {
        "$count$string"
    }