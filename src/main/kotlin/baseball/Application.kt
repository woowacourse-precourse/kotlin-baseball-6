package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    do {
        println("숫자 야구 게임을 시작합니다.")
        game()
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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
    val computerNumber = makeComputerNumber()
    do {
        Count.init()
        val myNumber = chooseMyNumber()
        errorCheckMyNumber(myNumber)
        compareEachNumber(myNumber, computerNumber)
        printResult()
    } while (Count.strike != 3)
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

fun errorCheckMyNumber(inputNumber: String) {
    val checkSet = mutableSetOf<Char>()
    if (inputNumber.length != 3) {
        throw IllegalArgumentException("숫자의 길이가 틀립니다")
    }
    for (i in inputNumber.indices) {
        if (inputNumber[i] > '9' || inputNumber[i] < '0') {
            throw IllegalArgumentException("숫자가 아닙니다")
        }
        checkSet.add(inputNumber[i])
    }
    if (checkSet.size < 3) {
        throw IllegalArgumentException("중복값이 있습니다")
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
