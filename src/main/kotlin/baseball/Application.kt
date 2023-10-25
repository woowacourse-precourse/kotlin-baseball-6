package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun createRandomNumbers(): List<Int>{
    var randomNumbers = mutableListOf<Int>()

    while(randomNumbers.size < 3){
        val number = Randoms.pickNumberInRange(1,9)
        if(!randomNumbers.contains(number)){
            randomNumbers.add(number)
        }
    }
    return randomNumbers
}

fun userInputNumbers(): List<Int>{
    var userInputNumberList = mutableListOf<Int>()
    val userInput = Console.readLine()

    for(i in 0 until userInput.length){
        userInputNumberList.add(userInput[i].code - '0'.code)
    }
    return userInputNumberList
}

fun checkResult(randomNumbers: List<Int>, userInputNumbers: List<Int>): List<Int>{
    var ball: Int = 0
    var strike: Int = 0

    for(i in 0 until userInputNumbers.size){
        if(randomNumbers.contains(userInputNumbers[i])){
            if(randomNumbers[i]==userInputNumbers[i]){
                strike +=1
            }
            else{
                ball +=1
            }
        }
    }
    return listOf(ball, strike)
}

fun printResult(result: List<Int>){
    val ball = result[0]
    val strike = result[1]

    if(ball==0 && strike==0){
        println("낫싱")
    }
    else if(ball==0){
        println("${strike}스트라이크")
    }
    else if(strike==0){
        println("${ball}볼")
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
}
