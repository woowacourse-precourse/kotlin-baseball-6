package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computer: MutableList<Int> = makeRandomNumber()
    val restart: Boolean = false

    println(computer) //Debug
    println("숫자 야구 게임을 시작합니다.")

    while (restart == false){
        print("숫자를 입력해주세요 : ")
        var userNumver = checkUserNumber()
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