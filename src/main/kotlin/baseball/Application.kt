package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    while(true){
        val targetNumber = makeNumber()
    }
}

fun makeNumber():MutableList<Int>{
    val computerNumber = mutableListOf<Int>()
    while(computerNumber.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNumber.contains(randomNumber)){
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}