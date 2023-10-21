package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    gameStartMessage()
    val computerNum = createRandomNum()
    println("computerNum $computerNum")
    val userNum = getUserInputNum()

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