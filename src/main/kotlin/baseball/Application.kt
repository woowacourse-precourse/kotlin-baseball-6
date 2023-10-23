package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    NumberBaseballGame().start()
}

class NumberBaseballGame {
    private val output = OutputWriter()
    fun start() {
        output.printGameStart()
        output.printReceiveNumberInput()
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
