package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val message = "숫자 야구 게임을 시작합니다"
    println(message)

    startGame()
}

fun startGame() {
    val answer = getRandomNums()

    val inputNumList = getUserInput()
    if (isNumValidated(inputNumList)) {
        // ToDo...
    }
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