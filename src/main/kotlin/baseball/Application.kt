package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

val computer = ArrayList<Int>() //컴퓨터 숫자
val myNumber = ArrayList<Int>() //내 숫자

fun main() {
    val msg = Message() //메시지 객체 생성
    System.out.println("숫자 야구 게임을 시작합니다.")
    MakeRandom()

    while (true) { //숫자를 다 맞추면 break
        var strike = 0
        var ball = 0
        var out = 0
        System.out.print("숫자를 입력해주세요 : ")

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
            val input = readLine()
            if (input == "1") {
                MakeRandom()
                continue
            } else {
                break;
            }
        } else{
            msg.scoreMessage(strike,ball, out)
        }
    }
}

fun MakeRandom() {
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
    val number = readLine()
    var error = CheckError()
    error.check(number)
}


