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

fun main() {
    println("숫자 야구 게임을 시작합니다.")
}
