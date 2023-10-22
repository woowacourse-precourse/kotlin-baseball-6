package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    runBaseballGame()
}

// 게임 매니져 메서드
fun runBaseballGame(){
    val computerNumber = generateRandomNumber()
    val userInput = getUserInput()
}

// 컴퓨터의 랜덤한 숫자 생성
fun generateRandomNumber(): ArrayList<Int>{
    val computerNumber = ArrayList<Int>()

    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }

    return computerNumber
}

// 사용자 입력
fun getUserInput(): ArrayList<Int>{
    val userInputString = Console.readLine()
    val userInputList = ArrayList<Int>()

    for(i in 0..2){
        userInputList.add(userInputString[i].toString().toInt())
    }

    return userInputList
}
