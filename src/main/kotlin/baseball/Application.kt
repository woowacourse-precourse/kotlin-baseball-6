package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restart: Boolean = false
    while(restart == false) {
        val computer: MutableList<Int> = makeRandomNumber()
        var strike = 0
        println("숫자 야구 게임을 시작합니다.")

        while (restart == false) {
            print("숫자를 입력해주세요 : ")
            var userNumber = checkUserNumber()
            strike = compareBothComputerAndUser(computer, userNumber)

            if (strike == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        restart = checkToRestart()
    }
}

fun makeRandomNumber() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun checkUserNumber() : Int {
    var userString = readLine()
    var userNumber = userString?.toInt()

    if (userNumber in 100..999 && userNumber != null){
        return userNumber
    }else{
        throw IllegalArgumentException()
    }
}

fun compareBothComputerAndUser(computer: MutableList<Int>, userNumber: Int) : Int{
    val userNumberMut = mutableListOf<Int>()
    var tempNumber = userNumber
    var strike = 0
    var ball = 0
    while (tempNumber > 0 ) {
        userNumberMut.add(0, tempNumber % 10)
        tempNumber /= 10
    }

    for (i in 0..userNumberMut.size-1){
        for (j in 0..computer.size-1){
            if (userNumberMut[i] == computer[j]){
                if (i == j){
                    strike ++
                }else if (i != j){
                    ball++
                }
            }
        }
    }

    if(strike == 0 && ball == 0){
        println("낫싱")
    }else if(strike == 0 && ball != 0){
        println("${ball}볼")
    }else if(strike != 0 && ball == 0){
        println("${strike}스트라이크")
    }else{
        println("${ball}볼 ${strike}스트라이크")
    }

    return strike
}

fun checkToRestart(): Boolean{
    var userChoice = "0"
    var restart: Boolean = false

    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
    userChoice = readLine()!!

    if(userChoice == "2" ){ restart = true }
    else if(userChoice == "1" ){ restart = false }
    return restart
}