package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    var computer = Computer()
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        print("숫자를 입력해주세요: ")
        var numberBall = Console.readLine()

        if (isAvaliableInput(numberBall)) {
            val result = computer.judgeNumberBall(numberBall)
            println(result)

            if (computer.isThreeStrike()) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                var newOrder = Console.readLine()
                if (newOrder.equals("1")) {
                    computer.initializeGame()
                } else if (newOrder.equals("2")) {
                    break
                } else {
                    throw IllegalArgumentException()
                    break
                }
            }
        } else {
            break
        }
    }
}

fun isAvaliableInput(numberBall: String?): Boolean {
    try {
        if (numberBall != null && numberBall.length == 3) {
            for (i in 0..2) {
                var number = numberBall[i].code - 48
                if (number !in 1..9) {
                    throw IllegalArgumentException()
                }
            }
            return true
        } else {
            throw IllegalArgumentException()
        }
    } catch (e: IllegalArgumentException) {
        return false
    }

}


