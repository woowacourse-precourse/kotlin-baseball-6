package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    var computer = Computer()
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        print("숫자를 입력해주세요: ")
        var str = Console.readLine()

        if (isAvailableInput(str)) {
            val numberBall = mapStringToNumberBall(str)
            val result = computer.judgeNumberBall(numberBall)
            println(result)

            if (computer.isThreeStrike()) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                var newOrder = Console.readLine()
                if (newOrder.equals("1")) {
                    computer.initializeGame()
                } else if (newOrder.equals("2")) {
                    break
                } else {
                    throw IllegalArgumentException()
                    break
                }
            }
        } else {
            throw IllegalArgumentException()
            break
        }
    }
}

fun mapStringToNumberBall(str: String): MutableList<Int> {
    var numberList = mutableListOf<Int>()
    str.forEach {
        numberList.add(it.code - 48)
    }
    return numberList
}

fun isAvailableInput(input: String?): Boolean {
    try {
        if (input != null && input.length == 3) {

            if (isInProperRange(input) && isAllDifferentNumber(input)) {
                return true
            }
            throw Error()
        } else {
            throw Error()
        }
    } catch (e: Error) {
        return false
    }

}

fun isInProperRange(str: String): Boolean {
    for (i in 0..2) {
        var number = str[i].code - 48
        if (number !in 1..9) {
            return false
        }
    }
    return true
}

fun isAllDifferentNumber(str: String): Boolean {
    if (!str.substring(1).contains(str[0]) && !str.substring(0, 1).contains(str[2])) {
        return true
    } else {
        return false
    }
}


