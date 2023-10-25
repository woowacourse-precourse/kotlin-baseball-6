package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val message = "숫자 야구 게임을 시작합니다"
    println(message)

    try {
        startGame()
    } catch (e: IllegalArgumentException) {
        print(e)
        return
    }
}

fun startGame() {
    val answer = getRandomNums()
    var strike = 0


    while (strike != 3) {
        val inputNumList = getUserInput()
        if (!isNumValidated(inputNumList)) {
            throw IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.")
        }
        var (ball, strike) = matchEachNums(answer, inputNumList)
        printResult(ball, strike)
    }
}

fun printResult(ball: Int, strike: Int) {
    val str = when {
        (strike == 0 && ball == 0) -> "낫싱"
        (strike == 0) -> ball.toString() + "볼"
        (ball == 0) -> strike.toString() + "스트라이크"
        else -> ball.toString() + "볼 " + strike.toString() + "스트라이크"
    }
    print(str)
}

fun matchEachNums(answer: List<Int>, input: List<Int>): Pair<Int, Int> {
    var strike = 0
    var ball = 0
    for (i in 0 until 3) {
        if (answer[i] == input[i])
            strike++
    }
    for (i in 0 until 3) {
        if (answer.contains(input[i]))
            ball++
    }
    ball -= strike

    return Pair(ball, strike)
}

fun getUserInput(): MutableList<Int> {
    val inputNum = Console.readLine()
    val numList = inputNum.map { it.toString().toInt() }.toMutableList()
    return numList
}

fun isNumValidated(list: List<Int>): Boolean {
    if (list.size != 3)
        return false
    for (num in list) {
        if (num !in 1 until 10)
            return false
    }
    return true
}

fun getRandomNums(): List<Int> {
    val resultList = mutableListOf<Int>()
    while (resultList.size < 3) {
        val num = Randoms.pickNumberInRange(1, 9)
        if (!resultList.contains(num)) {
            resultList.add(num)
        }
    }
    return resultList
}