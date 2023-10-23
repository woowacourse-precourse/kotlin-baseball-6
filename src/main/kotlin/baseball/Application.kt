package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNum = getRandomNum()
    do {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine().toInt()
        val inputNum = setUserNum(input)
    } while (compareNumbers(computerNum, inputNum))
}

fun getRandomNum(): List<Int> {
    val numList: MutableList<Int> = mutableListOf()
    while (numList.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!numList.contains(randomNum)) {
            numList.add(randomNum)
        }
    }
    return numList.toList()
}

fun setUserNum(inputNum: Int): List<Int> {
    val numList: MutableList<Int> = mutableListOf()
    var num = inputNum
    while (num > 0) {
        numList.add(num % 10)
        num /= 10
    }
    return numList.reversed().toList()
}

fun compareNumbers(computerList: List<Int>, userList: List<Int>): Boolean {
    var strike = 0
    var ball = 0
    for (userIdx in userList.indices) {
        val userNum = userList[userIdx]
        val comIdx = computerList.indexOf(userNum)
        if (comIdx != -1) {
            if (comIdx == userIdx) {
                strike += 1
            } else {
                ball += 1
            }
        }
    }
    println("$strike strike, $ball ball")
    return strike != 3
}