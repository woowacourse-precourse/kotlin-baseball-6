package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
const val THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."



fun main() {
    var computer: List<Int> = listOf()
    var user: List<Int>
    var areUReady = true
    var gameRestart = true

    println(START_MESSAGE)
    while(areUReady or gameRestart){
        if(gameRestart) {
            computer = generateRandomNumber()
        }
        user = userInput()
        areUReady = game(computer,user)
        gameRestart = gameOver(areUReady)
    }
}

fun generateRandomNumber(): List<Int> {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return computer
}

fun userInput(): List<Int> {
    print(INPUT_NUMBER_MESSAGE)
    val user = Console.readLine().map {it.digitToInt()}

    if(user.contains(0)) {
        throw IllegalArgumentException("1~9 사이의 값을 입력해주세요")
    }
    if(user.size != 3) {
        throw IllegalArgumentException("3자리 수를 입력해주세요")
    }
    if(user.toSet().size != 3) {
        throw IllegalArgumentException("중복 되지 않는 숫자를 입력해주세요")
    }
    if(user.isEmpty()){
        throw IllegalArgumentException("값을 넣어주세요")
    }
    return user
}

fun game(computer: List<Int>, user: List<Int>):Boolean {
    var ball = 0
    var strike = 0

    for (i in computer.indices) {
        if(user[i] !in computer){
            continue
        }
        if (computer[i] == user[i]) {
            strike++
            continue
        }
        else {
            ball++
        }
    }
    println(compareNumber(ball, strike))

    if (strike == 3) {
        println(THREE_STRIKE_MESSAGE)
        return false
    }
    return true
}



fun compareNumber(ball:Int, strike: Int): String {

    var str = ""
    if (ball == 0 && strike == 0) {
        print("낫싱")
    }
    else if (ball == 0 && strike > 0) {
        print("${strike}스트라이크")
    }
    else if (strike == 0 && ball > 0) {
        print("${ball}볼")
    }else{
        print("${ball}볼 ${strike}스트라이크")}
    return str
}


fun gameOver(areUDone:Boolean): Boolean {
    val userReply : Int

    if(!areUDone){
        println(RESTART_MESSAGE)
        userReply = Console.readLine().toInt()
        return when (userReply) {
            1 -> true
            2 -> false
            else -> throw IllegalArgumentException("1 또는 2를 선택해주세요")
        }
    }
    return false
}
