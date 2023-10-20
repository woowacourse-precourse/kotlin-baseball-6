package baseball

import baseball.util.GameState
import camp.nextstep.edu.missionutils.*
fun main() {
    appStart()
}

fun appStart(){
    println(GameState.GAME_START_MESSAGE)
    do{
        gameStart()
    } while(true)

}

fun gameStart(){

}





fun inputNumber(): MutableList<Int> {

    val playNumber = mutableListOf<Int>()
    print(GameState.NUMBER_INPUT_MESSAGE)
    val inputNumber = Console.readLine()
    if (inputNumberCheck(inputNumber)) {
        inputNumber.forEach {
            playNumber.add(it - '0')
        }
        return playNumber
    }
    throw IllegalArgumentException()
}

fun inputNumberCheck(inputNumber: String): Boolean {

    if (inputNumber.length != 3) return false
    val duplicateCheckArray = BooleanArray(9) // 중복 숫자 확인 배열

    for (num in inputNumber) {
        if (num !in '1'..'9') { // 유효 형식 확인
            return false
        }
        if (duplicateCheckArray[num - '1']) { // 중복 숫자 확인
            return false
        }
        duplicateCheckArray[num - '1'] = true
    }
    return true
}

fun getInputResult(targetNumber: MutableList<Int>, inputNumber: MutableList<Int>): Boolean {

    var strike = 0
    var ball = 0

    for (i in 0..2) {
        if (targetNumber[i] == inputNumber[i]) strike++
    }
    if (targetNumber[0] == inputNumber[1]) ball++
    if (targetNumber[0] == inputNumber[2]) ball++
    if (targetNumber[1] == inputNumber[0]) ball++
    if (targetNumber[1] == inputNumber[2]) ball++
    if (targetNumber[2] == inputNumber[0]) ball++
    if (targetNumber[2] == inputNumber[1]) ball++

    if (strike == 0 && ball == 0) {
        println(GameState.MATCHING_ZERO_MESSAGE)
        return false
    }
    if (strike == 3) {
        println(GameState.MATCHING_ALL_MESSAGE)
        return true
    }

    if (ball != 0) print("${ball}볼 ")
    if (strike != 0) print("${strike}스트라이크")
    println()
    return false
}

fun gameRestartCheck(): Boolean {

    println(GameState.GAME_RESTART_MESSAGE)
    val restart = Console.readLine()
    if (restart != "1" && restart != "2") throw IllegalArgumentException()
    return restart == "1"
}