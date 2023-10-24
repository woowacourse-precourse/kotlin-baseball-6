package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    NumberBaseballGame().start()
}

class NumberBaseballGame {
    private val output = OutputWriter()
    fun start() {
        output.printGameStart()
        output.printReceiveNumberInput()
        inputUserNumbers()
    }

    //서로 다른 3자리의 수 입력
    private fun inputUserNumbers(): String? {
        val user = Console.readLine()

        if (user.length != 3 || user.toSet().size != 3) {
            throw IllegalArgumentException()
        }
        return user
    }

    //1~9 범위의 서로 다른 3자리의 수 생성
    private fun generateRandomNumbers(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}

class OutputWriter {
    fun printGameStart() = println("숫자 야구 게임을 시작합니다.")
    fun printReceiveNumberInput() = print("숫자를 입력해주세요 : ")
}
