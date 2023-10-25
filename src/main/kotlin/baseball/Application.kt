package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임에 오신 것을 환영합니다!")

    while (true) {
        try {
            println("[1] 게임 시작하기 [2] 게임 종료하기")
            val selectStart = Console.readLine()?.toInt()

            when (selectStart) {
                1 -> {
                    println("숫자 야구 게임을 시작합니다.")
                    val computer = Computer()
                    computer.createNumbers()
                    playGame(computer)
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
                val comRandom = Randoms.pickNumberInRange(1, 9)
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
            val userInput = Console.readLine()

            if (userInput == null) {
                throw IllegalArgumentException("[Error] 입력된 값이 없습니다. 다시 입력해주세요.")
            } else if (userInput.length != 3) {
                throw IllegalArgumentException("[Error] 3자리의 수를 입력해주세요.")
            } else if (!userInput.all { it.isDigit() }) {
                throw IllegalArgumentException("[Error] 숫자만 입력해주세요.")
            } else if (userInput.toSet().size != 3) {
                throw IllegalArgumentException("[Error] 숫자가 중복되었습니다.")
            } else {
                return userInput.map { it.toString().toInt() }.toIntArray()
            }
        }
    }
}

fun playGame(computer: Computer) {
    val user = User()
    var strike: Int
    var ball: Int

    while (true) {
        val userNums = user.inputNums()
        strike = 0
        ball = 0

        for (index in userNums.indices) {
            if (userNums[index] == computer.randNums[index]) {
                strike++
            } else if (computer.randNums.contains(userNums[index])) {
                ball++
            }
        }

        when {
            strike == 3 -> {
                println("3개의 숫자를 모두 맞히셨습니다!\n게임 종료")
                if (askRestart()) {
                    playGame(Computer())
                } else {
                    return
                }
            }

            strike > 0 && ball == 0 -> println("$strike 스트라이크")
            strike == 0 && ball > 0 -> println("$ball 볼")
            strike > 0 && ball > 0 -> println("$strike 스트라이크 $ball 볼")
            strike == 0 && ball == 0 -> println("낫싱")
        }
    }
}

fun askRestart(): Boolean {
    while (true) {
        println("게임을 다시 시작하시겠습니까?")
        return false
    }
}