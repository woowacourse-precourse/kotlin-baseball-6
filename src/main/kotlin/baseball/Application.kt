package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    do {
        game()
    } while (restart())
}

object Count {
    var strike = 0
    var ball = 0
    fun init() {
        strike = 0
        ball = 0
    }
}

fun game() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNumber = makeComputerNumber()
    println(computerNumber)
    do {
        Count.init()
        val myNumber = chooseMyNumber()
        errorCheckMyNumber(myNumber.toList())
        compareEachNumber(myNumber, computerNumber)
        printResult()
    } while (Count.strike != 3)
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
    return Console.readLine()
}


fun errorCheckMyNumber(inputNumber: List<Char>) {
    if (inputNumber.size != 3) {
        throw IllegalArgumentException("입력의 길이가 잘못되었습니다.")
    }
    for (i in inputNumber.indices) {
        if (inputNumber[i] > '9' || inputNumber[i] < '0') {
            throw IllegalArgumentException("입력값에 숫자가 아닌 값이 있습니다.")
        }
        if (inputNumber.count {
                it == inputNumber[i]
            } > 1) throw IllegalArgumentException("입력값에 중복된 숫자가 있습니다.")
    }
}

fun compareEachNumber(myNumber: String, computerNumber: List<Char>) {
    for (i in myNumber.indices) {
        if (myNumber[i] == computerNumber[i]) {
            Count.strike++
            continue
        }
        if (computerNumber.contains(myNumber[i])) {
            Count.ball++
        }
    }
}

fun printResult() {
    if (Count.ball != 0) {
        print("${Count.ball}볼 ")
    }
    if (Count.strike != 0) {
        print("${Count.strike}스트라이크")
    }
    if (Count.strike == 0 && Count.ball == 0) {
        print("낫싱")
    }
    println()
}

fun restart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        '1'.toString() -> {
            true
        }

        '2'.toString() -> {
            false
        }

        else -> {
            throw IllegalArgumentException("1 또는 2로 입력하지 않았습니다.")
        }
    }
}