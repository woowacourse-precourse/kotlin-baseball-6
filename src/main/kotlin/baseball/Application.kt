package baseball

import java.lang.Exception

fun main() {
    println("숫자 야구 게임에 오신 것을 환영합니다!")

    while (true) {
        try {
            println("[1] 게임 시작하기 [2] 게임 종료하기")
            val selectStart = readLine()?.toInt()

            when (selectStart) {
                1 -> {
                    println("숫자 야구 게임을 시작합니다.")
                    val computer = Computer()
                    computer.createNumbers()
                }

                2 -> {
                    println("숫자 야구 게임을 종료합니다.")
                    break
                }

                else -> {
                    println("잘못된 입력입니다. 다시 입력해주세요.")
                }
            }
        } catch (e: NumberFormatException) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
        }
    }
}

class Computer {
    var randNums = IntArray(3)

    fun createNumbers() {
        for (computerNum in randNums.indices) {
            while (true) {
                val comRandom = (1..9).random()
                if (!randNums.contains(comRandom)) {
                    randNums[computerNum] = comRandom
                    break
                }
            }
        }
        println("랜덤 숫자를 선택완료했습니다.")
    }
}

class User {
    fun inputNums(): IntArray {
        while (true) {
            println("각 자리가 겹치지 않는 세 자리의 숫자를 입력해주세요. 예시 - 789")
            val userInput = readLine()

            if (userInput == null) {
                println("[Error] 입력된 값이 없습니다. 다시 입력해주세요.")
            } else if (!userInput.all { it.isDigit() }) {
                println("[Error] 숫자만 입력해주세요.")
            } else if (userInput.toSet().size != 3) {
                println("[Error] 숫자가 중복되었습니다.")
            } else if (userInput.length != 3) {
                println("[Error] 3자리의 수를 입력해주세요.")
            } else {
               println("입력하신 숫자는 ${userInput}입니다.")
            }
        }
    }
}
