package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computer: MutableList<Int> = makeRandomNumber()
    val restart: Boolean = false

    println(computer) //Debug
    println("숫자 야구 게임을 시작합니다.")

    while (restart == false){
        var userNumber = checkUserNumber()
        var result = compareBothComputerAndUser(computer, userNumber)
        
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

    print("숫자를 입력해주세요 : ")
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