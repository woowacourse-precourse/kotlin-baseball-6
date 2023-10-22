package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    gameStartMessage()
    val computerNum = createRandomNum()
    println("computerNum $computerNum")
    val userNum = getUserInputNum()
    compareNum(computerNum, userNum)

}

fun gameStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun createRandomNum(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInputNum(): List<Int> {
    val userInputChar = Console.readLine().toCharArray()
    val inputNum = userInputChar.map { num -> num.toString().toInt() }
    checkIsValidNum(inputNum)
    return inputNum
}

fun checkIsValidNum(inputNum: List<Int>) {
    if (inputNum.size != 3) throw IllegalArgumentException("3자리의 수를 입력해주세요")
    for (num in inputNum) {
        if (inputNum.count { (it == num) } > 1)
            throw IllegalArgumentException("서로 다른 숫자를 입력해주세요")
        else if (num < 1 || num > 9)
            throw IllegalArgumentException("각각 1~9 사이의 숫자를 입력해주세요")
    }
}

fun compareNum(computerNum: List<Int>, userNum: List<Int>) {

    val strike = howManyStrike(computerNum, userNum)
    val ball = howManyBall(computerNum, userNum, strike)

    if (ball == 0 && strike == 0) {
        print("낫싱")
    } else if (strike == 3) {
        println("${strike}스트라이크")
    } else if (ball == 0) {
        println("${strike}스트라이크")
    } else if (strike == 0) {
        println("${ball}볼")
    } else {
        print("${ball}볼 ${strike}스트라이크")
    }

}

fun howManyStrike(computerNum: List<Int>, userNum: List<Int>): Int {
    var strikeNum = 0
    for (idx in 0..2) {
        if (computerNum[idx] == userNum[idx])
            strikeNum += 1
    }
    return strikeNum
}

fun howManyBall(computerNum: List<Int>, userNum: List<Int>, strikeNum: Int): Int {
    var ballNum = 0
    for (num in computerNum) {
        if (userNum.contains(num)) ballNum++
    }

    return ballNum - strikeNum
}

fun gameOver(): STATE {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    return when (Console.readLine().toString().toInt()) {
        1 -> STATE.RESTART
        2 -> STATE.END
        else -> throw IllegalArgumentException("1 혹은 2만 입력하세요")
    }
}


enum class STATE {
    GAMING,
    RESTART,
    END,
}