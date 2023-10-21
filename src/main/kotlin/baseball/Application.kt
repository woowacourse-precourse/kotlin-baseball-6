package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    do {
        game()
    } while (restart())
}

fun game() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNumber = makeComputerNumber()
    var strike = 0
    while (strike != 3) {
        val myNumber = chooseMyNumber()
        strike = compareNumber(myNumber, computerNumber)
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun makeComputerNumber(): List<Char> {
    val computer = mutableListOf<Char>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!(computer.contains(randomNumber.toChar() + 48))) {
            computer.add(randomNumber.toChar() + 48)
        }
    }
    return computer
}

fun chooseMyNumber(): String {
    print("숫자를 입력해주세요 : ")
    var inputNumber = Console.readLine()
    checkMyNumber(inputNumber)
    return inputNumber
}

fun checkMyNumber(inputNumber: String) {

    val checkSet = mutableSetOf<Char>()
    if (inputNumber.length != 3) {
        throw IllegalArgumentException("숫자의 길이가 틀립니다")
    }
    for (i in inputNumber) {
        if (i > '9' || i < '0') {
            throw IllegalArgumentException("숫자가 아닙니다")
        }
        checkSet.add(i)
    }
    if (checkSet.size != 3) {
        throw IllegalArgumentException("중복된 수가 있습니다")
    }
}


fun compareNumber(myNumber: String, computerNumber: List<Char>): Int {
    var ball = 0
    var strike = 0
    var out = 0
    var index = 0
    for (i in myNumber) {
        if (computerNumber.contains(i)) {
            if (computerNumber[index] == i) {
                strike++;
            } else {
                ball++;
            }
        } else {
            out++;
        }
        index++;
    }
    printResult(strike,ball,out)
    return strike
}

fun printResult(strike : Int , ball:Int , out :Int){
    if (ball != 0) {
        print("${ball}볼 ")
    }
    if (strike != 0) {
        print("${strike}스트라이크")
    }
    if (out == 3) {
        print("낫싱")
    }
    print('\n')
}


fun restart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restartNumber = Console.readLine()
    return when (restartNumber) {
        '1'.toString() -> {
            true
        }

        '2'.toString() -> {
            false
        }

        else -> {
            throw IllegalArgumentException("1또는 2로 입력안함")
        }
    }
}
