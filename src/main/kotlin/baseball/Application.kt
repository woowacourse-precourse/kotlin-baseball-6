package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do {

        val randomList = setRandomNum()

        do {
            val numList = inputNum()
            processException(numList)

            val (strike, ball) = countStAndBall(randomList, numList)

            printDecision(strike, ball)

        } while (strike != 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val flag = Console.readLine().toInt()
    } while (flag != 2)

}

fun setRandomNum() : List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun inputNum() : MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val number = Console.readLine()
    val numberList = number.map { it.toString().toInt() }.toMutableList()

    return numberList
}
fun processException(numList: List<Int>) {
    var isDupli: Boolean = false
    for (n in numList) {
        if (numList.count { it == n } > 1) {
            isDupli = true
            break
        }
    }

    if (numList.size != 3 || numList.any { it < 1 } || isDupli)
        throw IllegalArgumentException("잘못된 입력입니다. .")
}
fun countStAndBall(randomList: List<Int>, numList: List<Int>): Pair<Int, Int> {
    var strike: Int = 0
    var ball: Int = 0
    for (i in 0..2) {
        if (randomList[i] in numList) {
            if (randomList[i] == numList[i]) {
                strike += 1
            } else {
                ball += 1
            }
        }
    }
    return Pair(strike, ball)
}
fun printDecision(strike: Int, ball: Int) {
    val result = when {
        (strike == 0 && ball == 0) -> "낫싱"
        (ball == 0) -> String.format("%d스트라이크", strike)
        (strike == 0) -> String.format("%d볼", ball)
        else -> String.format("%d볼 %d스트라이크", ball, strike)
    }
    println(result)
}