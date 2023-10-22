package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}


fun pickComputerNumber(): String {
    val computer:MutableList<Int> = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun inputUserNumber(): String {
    print("수를 입력하세요: ")
    val user: String = Console.readLine()

    return user
}

fun compareWithNumber(answer:String, userNumber: String): Pair<Int, Int> {
    var strike: Int = 0
    var ball: Int = 0

    for (idx in userNumber.indices) {
        if (userNumber[idx] == answer[idx]) {
            strike++
            continue
        }
        if (userNumber.contains(answer[idx])) {
            ball++
        }
    }
    printHint(strike, ball)
    return Pair(strike, ball)
}

fun printHint(strike:Int, ball:Int) {
    var hint = ""

    if(ball != 0){
        hint += "${ball}볼 "
    }
    if(strike != 0){
        hint += "${strike}스트라이크"
    }
    if(strike==0 && ball==0) {
     hint = "낫싱"
    }

    println(hint)
}

