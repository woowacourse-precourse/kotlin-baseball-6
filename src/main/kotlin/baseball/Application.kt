package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println(StringRes.START_MSG)
    do {
        val targetList = setNumber()

        do {
            val input = getInput(InputTypeEnum.HIT)
            val inputList = input.map {
                it.code - 48
            }

            val hitCheck = checkTarget(targetList, inputList)
            println(hitCheck)
        } while (hitCheck.strike != Const.NUMBER_CNT)

        println(StringRes.ENDING_MSG)
        println(StringRes.REPLAY_MSG)
    }while(getInput(InputTypeEnum.RESTART) == Const.REPLAY)

}

fun setNumber(): List<Int> {
    val list = mutableListOf<Int>()
    while (list.size < Const.NUMBER_CNT) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (list.contains(randomNumber).not()) {
            list.add(randomNumber)
        }
    }
    return list
}

fun getInput(type: InputTypeEnum): String {
    val userInput = Console.readLine()

    return when (type) {
        InputTypeEnum.HIT -> {
            val numberChecker = userInput.all {
                it in '1'..'9'
            }

            val distinctChecker = userInput.map {
                it
            }.distinct().size == Const.NUMBER_CNT

            if (numberChecker.not() || distinctChecker.not() || userInput.length != Const.NUMBER_CNT) {
                throw IllegalArgumentException()
            } else {
                userInput
            }
        }

        InputTypeEnum.RESTART -> {
            if (userInput != Const.REPLAY && userInput != Const.END) {
                throw IllegalArgumentException()
            } else {
                userInput
            }
        }
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

