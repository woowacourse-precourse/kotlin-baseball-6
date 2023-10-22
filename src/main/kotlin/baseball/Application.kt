package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGameMessage()
    do {
        gameRun()
    }while (chooseRestartAndExit())
}

fun printStartGameMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun gameRun() {
    val answer = pickComputerNumber()
    while(true) {
        val userNumber = inputUserNumber()
        val score = compareWithNumber(answer, userNumber)
        printHint(score.first, score.second)
        if(score.first == 3){
            gameOver()
            return
        }
    }
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

    validationInputUserNumber(user)
    return user
}

fun validationInputUserNumber(userNumber: String) {
    if(userNumber.length > 3) {
        throw IllegalArgumentException("3자리가 아닌 입력값입니다.")
    }

    if((!userNumber.all { String -> String.isDigit() }) || (userNumber.contains("0"))) {
        throw IllegalArgumentException("숫자가 아닌 입력값이 포함되었습니다.")
    }
}


fun compareWithNumber(answer:String, userNumber: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (idx in userNumber.indices) {
        if (userNumber[idx] == answer[idx]) {
            strike++
            continue
        }
        if (userNumber.contains(answer[idx])) {
            ball++
        }
    }

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

fun gameOver(){
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun chooseRestartAndExit(): Boolean {
    val flag: Int = Console.readLine().toInt()
    if(flag==1){
        return true
    }
    println("종료합니다.")
    return false
}