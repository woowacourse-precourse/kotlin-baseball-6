package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import java.util.*

val computer = ArrayList<Int>() //컴퓨터 숫자
val myNumber = ArrayList<Int>() //내 숫자

fun main() {
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
            Message("strike")
            val input = readLine()
            if (input == "1") {
                MakeRandom()
                continue
            } else {
                break;
            }
        } else if (out == 3) {
            Message("nothing")
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball.toString() + "볼")
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike.toString() + "스트라이크")
        } else {
            System.out.println(ball.toString() + "볼 " + strike.toString() + "스트라이크")
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
    checknumber(number)
}

fun checknumber(number: String) { //숫자 검사
    if (number.length != 3) { //숫자가 3이 넘어가면 에러
        throw IllegalArgumentException("숫자가 3이 넘어갑니다.")
    }
    for (i in number.indices) { // 숫자가 아니면 에러
        if (number[i] < '1' || number[i] > '9') {
            throw IllegalArgumentException("숫자가 아닙니다.")
        }
    }
    for (i in number.indices) { //숫자가 중복되면 에러
        if (!myNumber.contains(Character.getNumericValue(number[i]))) {
            myNumber.add(Character.getNumericValue(number[i]))
        } else {
            throw IllegalArgumentException("숫자가 중복됩니다.")
        }
    }

}

fun Message(type: String) {
    if (type == "strike") {
        System.out.println("3스트라이크")
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    } else if (type == "nothing") {
        System.out.println("낫싱")
    }
}

