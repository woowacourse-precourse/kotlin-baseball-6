package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException


const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
const val THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료"
const val RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"

var strike = 0
var ball = 0




fun main() {

    gameStart()

}

fun gameStart() {

    var computer: MutableList<Int> = mutableListOf()
    var userNumber: List<Int> = listOf()

    var areUReady = true
    println(START_MESSAGE)

    while(areUReady) {

        areUReady = gameOver()

    }
}

fun generateRandomNumber(): MutableList<Int> {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun userInput(): List<Int> {

    val user = Console.readLine().map {it.digitToInt()}

    if(user.contains(0)) {
        throw IllegalArgumentException("1~9 사이의 값을 입력해주세요")
    }
    if(user.size != 3) {
        throw IllegalArgumentException("3자리 수를 입력해주세요")
    }
    if(user.toSet().size != user.size) {
        throw IllegalArgumentException("중복 되지 않는 숫자를 입력해주세요")
    }

    return user
}

fun ballCount(computer: List<Int>, user: List<Int>) :Int {

    for (i in computer.indices) {
        if (computer.contains(user[i])) {
            ball++
        }
    }

    return ball
}

fun strikeCount(computer: List<Int>, user: List<Int>) :Int {

    for (i in computer.indices) {
        if (computer[i] == user[i]) {
            strike++
        }
    }
    return strike
}

fun compareNumber(): String {

    val computerNumber = generateRandomNumber()
    val userNumber = userInput()

    while(true) {
        println(INPUT_NUMBER_MESSAGE)

        ballCount (computerNumber,userNumber)
        strikeCount (computerNumber, userNumber)

        var str = ""

        if (ball == 0 && strike == 0) {
            str = "낫싱"
        }
        if (ball == 0 && strike > 0) {
            str = "${strike}스트라이크"
        }
        if (strike == 0 && ball > 0) {
            str = "${ball}볼"
        } else {
            str = "${ball}볼 ${strike}스트라이크"
        }
        if (strike == 3) {
            "${strike}스트라이크\n${THREE_STRIKE_MESSAGE}"
            gameOver()
        }

        return str
    }
}

fun gameOver(): Boolean {
    val userReply = Console.readLine().toInt()

    if((userReply != 1) && (userReply !=2 )){
        println(RESTART_MESSAGE)
    }
    return when (userReply) {
        1 -> true
        2 -> false
        else -> gameOver()
    }
}
