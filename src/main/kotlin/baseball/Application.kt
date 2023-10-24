package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

import java.util.*

fun main() {
    var start = true

    while (start) {
        val computer = arrayListOf<Int>()
        computer.clear()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        println("숫자야구 게임 시작!!")
        println("1부터 9 사이의 숫자 3개를 입력하세요:")
        var attempt = 0

        while (true) {
            var strike = 0
            var ball = 0
            var nothing = 0

            val input = Console.readLine()

            if (input.length != 3 || input[0] == input[1] || input[1] == input[2] || input[0] == input[2]) {
                throw IllegalArgumentException("잘못된 값을 입력하셨습니다.")
            }

            attempt++
            for (i in input.indices) {
                if (input[i] - '0' == computer[i]) {
                    strike++
                } else if (computer.contains(input[i] - '0')) {
                    ball++
                } else {
                    nothing++
                }
            }

            if (strike == 3) {
                println("총 $attempt 시도 하셨습니다. 축하합니다!!")
                break
            }

            println("\n 판정 결과 : 스트라이크 = ${strike} 볼 = ${ball} 낫싱 = ${nothing}\n ")
        }

        println("재시작 하시겠습니까? (1: 재시작, 2: 종료)")
        val restart = Console.readLine()
        if (restart == "2") {
            start = false
        }
    }
    println("게임 종료!!")
}


