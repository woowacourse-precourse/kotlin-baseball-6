package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // 1. 게임 시작을 위한 세팅
    val answer = generateAnswer()

    playGame(answer)
    var check = isRestart()

    while (check[0] == 1) {
        val ans = generateAnswer()
        playGame(ans)
        check = isRestart()
    }
}

fun generateAnswer(): ArrayList<Int> {
    // 1. 게임 시작을 위한 세팅
    val computer = arrayListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun readInput(): IntArray {
    // 2. 사용자 입력
    print("숫자를 입력해주세요 : ")
    var inputData = Console.readLine()?.toCharArray()?.map { it.toString().toInt() }?.toIntArray()

    if (inputData == null || inputData.size != 3 || !inputData.all { it in 0..9 } || inputData.toSet().size != 3) {
        throw IllegalArgumentException()
    }
    return inputData
}

fun isRestart(): IntArray {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var inputData = Console.readLine()?.toCharArray()?.map { it.toString().toInt() }?.toIntArray()

    if (inputData == null || inputData.size != 1 || !inputData.all { it in 1..2 }) {
        throw IllegalArgumentException()
    }
    return inputData
}

fun playGame(answer: ArrayList<Int>) {
    // 3. Ball, Strike 검증 및 결과 출력

    println("숫자 야구 게임을 시작합니다.")

    var strike = 0

    while (strike != 3) {
        strike = 0
        var ball = 0

        val inputData = readInput()

        for ((index, i) in answer.withIndex()) {
            if (answer[index] == inputData[index]) strike++
            if (i in inputData) ball++
        }
        ball -= strike
        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else {
            if (ball != 0) {
                print("${ball}볼 ")
            }
            if (strike != 0) {
                print("${strike}스트라이크")
            }
            println()
        }
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}