package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    print("숫자를 입력해주세요 : ")
    val you = inputAndValidate()
    printResult(check(computer, you)
}

fun inputAndValidate(): List<Int> {
    val input = Console.readLine()
    return validate(input)
}

fun validate(input: String): List<Int> {
    if(input.length > 3) {
        IllegalArgumentException("3자리 이상을 입력하였습니다.")
    }
    val numbers = input.toList().map { Character.getNumericValue(it) }
    for (number in numbers) {
        if (number !in (1..9)) {
            IllegalArgumentException("수를 잘못 입력하였습니다.")
        }
    }
    return numbers
}

fun check(computer: MutableList<Int>, you: List<Int>): Pair<Int, Int> {
    var strike = 0
    var ball = 0
    for ((index, value) in you.withIndex()) {
        for ((index2, value2) in computer.withIndex()) {
            if(value == value2) {
                if(index==index2) {
                    strike++
                    continue
                }
                ball++
            }
        }
    }
    return Pair(strike, ball)
}

fun printResult(check: Pair<Int, Int>) : Boolean {
    val (strike, ball) = check
    if(strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    if(strike == 0) {
        if(ball == 0) {
            println("낫싱")
            return false
        }
        println("$ball 볼")
        return false
    }
    if(ball == 0) {
        println("$strike 스트라이크")
        return false
    }
    println("$ball 볼 $strike 스트라이크")
    return false
}