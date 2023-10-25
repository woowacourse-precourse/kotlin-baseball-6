package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}

fun playGame() {
    val user = User()
    val computer = Computer()
    computer.createNumbers()

    while (true) {
        val userNums = user.inputNums()
        var strike = 0
        var ball = 0

        for (index in userNums.indices) {
            if (userNums[index] == computer.randNums[index]) {
                strike++
            } else if (computer.randNums.contains(userNums[index])) {
                ball++
            }
        }

        if (strike > 0 && ball == 0) {
            println("$strike 스트라이크")
        } else if (strike == 0 && ball > 0) {
            println("$ball 볼")
        } else if (strike == 0 && ball == 0) {
            println("낫싱")
        } else {
            println("$strike 스트라이크 $ball 볼")
        }

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            if (!askRestart())
                break
            computer.createNumbers()
        }
    }
}

class Computer {
    var randNums: List<Int> = emptyList()

    fun createNumbers() {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        randNums = computer
    }
}

class User {
    fun inputNums(): IntArray {
        while (true) {
            while (true) {
                println("숫자를 입력해주세요 : ")
                val userInput = Console.readLine()

                if (userInput == null) {
                    throw IllegalArgumentException()
                } else if (userInput.length != 3) {
                    throw IllegalArgumentException()
                } else if (!userInput.all { it.isDigit() }) {
                    throw IllegalArgumentException()
                } else if (userInput.toSet().size != 3) {
                    throw IllegalArgumentException()
                } else {
                    return userInput.map { it.toString().toInt() }.toIntArray()
                }
            }
        }
    }
}


fun askRestart(): Boolean {
    while (true) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = Console.readLine()?.toInt()

        when (input) {
            1 -> {
                return true
            }

            2 -> {
                println("숫자 야구 게임을 종료합니다.")
                return false
            }

            else -> throw IllegalArgumentException()
        }
    }
}
