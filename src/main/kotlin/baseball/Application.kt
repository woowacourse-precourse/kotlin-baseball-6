package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    val user = mutableListOf<Int>()

    loop@do {
        computer.clear()
        setComputerNums(computer)
        while (true) {
            print("숫자를 입력해주세요 : ")

            var strike = 0
            var ball = 0

            user.clear()
            val input = Console.readLine()

            isValidateInputNumber(input)

            input.forEach { user.add(it.digitToInt()) }

                for(i in 1..9) {
                    var result = 0
                    user.forEachIndexed { _, value ->
                        if(value == i) result++
                    }
                    if(result > 1) throw IllegalArgumentException("zz")
                }

            computer.forEachIndexed { i, value ->
                repeat(3) { j ->
                    if (i == j) {
                        if (value == user[i]) strike++
                    } else {
                        if (value == user[j]) ball++
                    }
                }
            }

            if (strike == 3) {
                println("${strike}스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            } else if (strike != 0 && ball != 0) println("${ball}볼 ${strike}스트라이크")
            else if (ball != 0) println("${ball}볼")
            else if (strike != 0) println("${strike}스트라이크")
            else println("낫싱")
        }
    } while(restartOrNot(Console.readLine()))
}

private fun setComputerNums(computer: MutableList<Int>) {
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}

private fun restartOrNot(input: String?): Boolean {
    return try {
        getValidateRestartNumber(input) == 1
    } catch(e: IllegalArgumentException) {
        false
    }
}

fun getNotEmptyInt(string: String?): Int {
    val input = string?.trim()
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException("input String is null or empty")
    }
    if (input.toIntOrNull() == null) {
        throw IllegalArgumentException("input String cannot be parsed Int")
    }
    if(input.length > 3 ) throw IllegalArgumentException("input String cannot be parsed Int")
    return input.toInt()
}

fun isValidateInputNumber(string: String?) {
    val num = getNotEmptyInt(string)
    if (num < 123 || num > 987) {
        throw IllegalArgumentException("input number is unavailable")
    }
    if (num.toString().contains('0')) {
        throw IllegalArgumentException("input number is unavailable")
    }
}

fun getValidateRestartNumber(string: String?): Int {
    val num = getNotEmptyInt(string)
    if (num != 1 && num != 2) {
        throw IllegalArgumentException("restart number is unavailable")
    }
    return num
}