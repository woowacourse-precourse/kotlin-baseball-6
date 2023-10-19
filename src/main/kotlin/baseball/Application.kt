package baseball

import camp.nextstep.edu.missionutils.*

const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val MATCHING_ZERO = "낫싱"

fun main() {

    println(GAME_START_MESSAGE)

    var targetNumber = makeNumber()
    println(targetNumber)
    while(true){
        val inputNumber = inputNumber()
        if(inputNumber.isEmpty()){
            throw IllegalArgumentException()
        }
        getInputResult(targetNumber, inputNumber)
    }

}

fun getInputResult(targetNumber: MutableList<Int>, inputNumber: MutableList<Int>):Boolean{

    var strike = 0
    var ball = 0

    for(i in 0 .. 2){
        if(targetNumber[i] == inputNumber[i]) strike++
    }
    if(targetNumber[0] == inputNumber[1]) ball++
    if(targetNumber[0] == inputNumber[2]) ball++
    if(targetNumber[1] == inputNumber[0]) ball++
    if(targetNumber[1] == inputNumber[2]) ball++
    if(targetNumber[2] == inputNumber[0]) ball++
    if(targetNumber[2] == inputNumber[1]) ball++

    if(strike == 0 && ball == 0) {
        println(MATCHING_ZERO)
        return false
    }
    if(strike == 3){
        println("${strike}스트라이크")
        return true
    }

    if(ball != 0) print("${ball}볼 ")
    if(strike != 0) print("${strike}스트라이크")
    println()
    return false
}

fun makeNumber(): MutableList<Int>{

    val computerNumber = mutableListOf<Int>()

    while(computerNumber.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNumber.contains(randomNumber)){
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun inputNumber(): MutableList<Int>{

    val playNumber = mutableListOf<Int>()
    print(NUMBER_INPUT_MESSAGE)

    val inputNumber = Console.readLine()
    if(inputNumberCheck(inputNumber)){
        inputNumber.forEach {
            playNumber.add(it-'0')
        }
    }
    return playNumber
}

fun inputNumberCheck(inputNumber: String): Boolean{

    val duplicateCheckArray = BooleanArray(9) // 중복 숫자 확인 배열

    for(num in inputNumber){
        if(num !in '1' .. '9'){ // 유효 형식 확인
            return false
        }
        if(duplicateCheckArray[num-'1']){ // 중복 숫자 확인
            return false
        }
        duplicateCheckArray[num-'1'] = true
    }
    return true
}