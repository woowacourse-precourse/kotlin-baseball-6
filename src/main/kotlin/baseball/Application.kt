package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun createRandomNum(): String {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun enterNum(): String {
    val InputNum = Console.readLine()
    return InputNum
}

fun printResult(result: Pair<Int, Int>) {
    val strike = result.first
    val ball = result.second

    if (strike > 0 && ball == 0) {
        println("${strike}스트라이크")
        return
    }
    if (strike == 0 && ball > 0) {
        println("${ball}볼")
        return
    }
    if (strike == 0 && ball == 0) {
        println("낫싱")
        return
    }

    println("${ball}볼 ${strike}스트라이크")
    return
}

fun compareNum(comNum: String, playerNum: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0
    //var comNum = "123"
    for (index in playerNum.indices) {
        if (playerNum[index] == comNum[index]) {
            strike++
            continue
        }
        if (comNum.contains(playerNum[index])) {
            ball++
        }
    }
    return Pair(strike, ball)
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val comNum = createRandomNum()
//    var result = compareNum(comNum, "0")
//    while (result.first != 3 ) {
//        print("숫자를 입력해주세요 : ")
//        result = compareNum(comNum, enterNum())
//        printResult(result)
//    }
    do {
        do {
            print("숫자를 입력해주세요 : ")
            var result = compareNum(comNum, enterNum())
            printResult(result)
        } while (result.first != 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    } while (gameContinueOrQuit())
}

fun gameContinueOrQuit(): Boolean {
    var restart = Console.readLine()
    //사용자 1또는 2 입력 안할시 예외처리
    if (restart == "1") {
        return true
    }
    return false
}

class Computer {
    //숫자 생성
//    fun createRandomNum():MutableList<Int>{
//        val computer : MutableList<Int> = mutableListOf()
//        while (computer.size < 3) {
//            val randomNumber = Randoms.pickNumberInRange(1, 9)
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber)
//            }
//        }
//        return computer
//    }
    //숫자비교 및 출력


}

class Player {
//    //숫자입력 - 예외처리
//    fun enterNum()= Console.readLine()
//
//    //게임 종료 , 재시작여부

}