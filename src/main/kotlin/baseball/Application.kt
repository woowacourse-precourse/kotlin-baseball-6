package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    println(computer[1]) // 랜덤 확인 테스트


        print("숫자를 입력해주세요 : ")
        val user = readLine()!!
        val inputNum = mutableListOf<Int>()
        for (i in user) {
            inputNum.add(i.digitToInt())
        }

        var strike = 0
        var ball = 0
        var not = 0
        for (i in inputNum.indices) {
            if (inputNum[i] == computer[i]) {
                strike += 1
            } else if (computer.contains(inputNum[i])) {
                ball += 1
            } else {
                not += 1
            }
        }

        if (strike == 3) {
            println("스")
        } else if (not == 3) {
            println("낫")
        } else if (strike == 0 && ball == 0) {
            println("낫")
        } else if (strike > 0 && ball == 0) {
            println("스 $strike")
        } else if (strike == 0 && ball > 0) {
            println("볼 $ball")
        } else println("스 $strike, 볼 $ball")
    }

