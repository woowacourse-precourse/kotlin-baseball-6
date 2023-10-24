package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printFirstMessage()
    do {
        startGame()
    } while (checkExitStatus())
}

fun startGame() {
    val computerNumList = getComputerNumList()
    while (true) {
        val userNumList = getUserNum()
        val result = getBallAndStrike(computerNumList, userNumList)
        printResult(result)
        if (result.second == 3) {
            printGameOverMessage()
            return
        }

    }

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
    val ball = result.first
    val strike = result.second

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

fun printGameOverMessage(){
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun checkExitStatus(): Boolean {
    val exitStatus = Console.readLine().trim()
    checkValidExitStatus(exitStatus)
    return exitStatus == "1"
}

fun checkValidExitStatus(exitStatus: String) {
    if (exitStatus != "1" && exitStatus != "2") {
        throw IllegalArgumentException("1, 2 둘 중 하나만 입력 가능")
    }
}