package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val computer = mutableListOf<Int>() //컴퓨터 숫자
val myNumber = mutableListOf<Int>() //내 숫자

fun main() {
    val msg = Message() //메시지 객체 생성
    println("숫자 야구 게임을 시작합니다.")
    makeRandom()

    while (true) { //숫자를 다 맞추면 break
        var strike = 0
        var ball = 0
        var out = 0
        print("숫자를 입력해주세요 : ")

        inputNumber()

        for (i in 0..<myNumber.size) { //스트라이크,볼,아웃 검증
            if (myNumber[i] == computer[i]) {
                strike++
            } else if (computer.contains(myNumber[i])) {
                ball++
            } else {
                out++
            }
        }

        if (strike == 3) {
            msg.message("strike")
            val input = Console.readLine()
            if (input == "1") {
                makeRandom()
                continue
            } else {
                break;
            }
        } else{
            msg.scoreMessage(strike,ball, out)
        }
    }
}

fun makeRandom() {
    computer.clear()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}

fun inputNumber() {
    myNumber.clear() //리스트 제거
    val number = Console.readLine()
    var error = CheckError()
    error.check(number)
}


