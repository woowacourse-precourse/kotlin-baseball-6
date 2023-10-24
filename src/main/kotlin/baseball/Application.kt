package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun printFirstMessage(){
    println("숫자 야구 게임을 시작합니다.")
}

fun getComputerNumList(): MutableList<Int> {
    val computerNumList = mutableListOf<Int>()
    while (computerNumList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumList.contains(randomNumber)) {
            computerNumList.add(randomNumber)
        }
    }
    return computerNumList
}

fun getUserNum(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = Console.readLine().toString()
    isUserNumValid(userInput)
    return userInput.toCharArray()
        .map { it.digitToInt() }
        .toMutableList()

}

fun isUserNumValid(userInput: String) {
    if (userInput != null) {
        if (!userInput.trim().matches(Regex("\\d{3}"))) {
            throw IllegalArgumentException("3자리의 수 입력 요함.")
        }
        if (userInput.toCharArray().map { it.digitToInt() }.toMutableList().distinct().size != 3) {
            throw IllegalArgumentException("중복 숫자 에러")
        }
    }
}

fun getBallAndStrike(computerNumList: MutableList<Int>, userNumList: MutableList<Int>): Pair<Int, Int> {
    var ballCount = 0
    var strikeCount = 0

    for (i in 0..2) {
        if (computerNumList[i] == userNumList[i]) {
            strikeCount++
            continue
        }
        if (computerNumList[i] in userNumList) {
            ballCount++
        }
    }

    return Pair(ballCount, strikeCount)

}

fun printResult(result: Pair<Int, Int>) {
    val ball = result.second
    val strike = result.first

    if (strike == 0 && ball == 0) {
        println("낫싱")
        return
    }

    if (strike == 0) {
        println("${ball}볼")
        return
    }

    if (ball == 0) {
        println("${strike}스트라이크")
        return
    }

    println("${ball}볼 ${strike}스트라이크")
}