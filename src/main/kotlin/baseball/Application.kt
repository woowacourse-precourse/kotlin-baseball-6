package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val targetList = setNumber()

    do {
        val input = getInput()
        val inputList = input.map {
            it.code - 48
        }

        val hitCheck = checkTarget(targetList, inputList)
        println(hitCheck)
    }while (hitCheck.strike != 3)

}

fun setNumber(): List<Int> {
    val list = mutableListOf<Int>()
    while (list.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (list.contains(randomNumber).not()) {
            list.add(randomNumber)
        }
    }
    return list
}

fun getInput(): String {
    val userInput = Console.readLine()

    val numberChecker = userInput.all {
        it in '1'..'9'
    }

    val distinctChecker = userInput.map {
        it
    }.distinct().size == 3

    if (numberChecker.not() || distinctChecker.not() || userInput.length != 3) {
        throw IllegalArgumentException()
    } else {
        return userInput
    }
}

fun checkTarget(targetList: List<Int>, inputList: List<Int>): CheckResult {
    var strike = 0
    var ball = 0
    for (i in inputList.indices) {
        val index = targetList.indexOf(inputList[i])
        if (index != -1) {
            if (index == i) strike++ else ball++
        }
    }

    return CheckResult(strike, ball)
}

