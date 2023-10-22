package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    var computer = Computer()
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        print("숫자를 입력해주세요: ")
        var numberBall = Console.readLine()
        //판정하기
        if (isAvaliableInput(numberBall)) {
            println(computer.judgeNumberBall(numberBall))
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


