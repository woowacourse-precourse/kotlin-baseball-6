package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()

    do{
        computer.clear()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        println("랜덤 숫자: "+computer)

        var strike : Int = 0
        var ball : Int = 0
        var index : Int = 1
        while (strike !=3) {
            print("숫자를 입력해주세요 : ")
            val num = Console.readLine()

            try {
                val numList = num.map { it.toString().toInt() }.toMutableList()
                var isDupli : Boolean = false
                for (n in numList) {
                    if (numList.count { it == n } > 1) {
                        isDupli = true
                        break
                    }
                }

                if (numList.size != 3 || numList.any { it < 1 } || isDupli) {
                    throw IllegalArgumentException("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력해주세요.")
                }
                strike = 0
                ball = 0
                for (i in 0..2) {
                    if (computer[i] in numList) {
                        if (computer[i] == numList[i]) {
                            strike += 1
                        }
                        else {
                            ball += 1
                        }
                    }
                }

                val result = when {
                    (strike == 0 && ball == 0) -> "낫싱"
                    (ball == 0) -> String.format("%d스트라이크", strike)//strike.toString() + "스트라이크"
                    (strike == 0) -> ball.toString() + "볼"
                    else -> String.format("%d볼 %d스트라이크", ball, strike)
                }
                println(result)

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        index = Console.readLine().toInt()
    } while (index != 2)

}
