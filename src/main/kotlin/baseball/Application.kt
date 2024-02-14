package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    while (true) {
        println("숫자 야구 게임을 시작합니다.")
        val numberSize = 3
        val computer = mutableListOf<Int>()
        while (computer.size < numberSize) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        while (true) {
            var ballCount = 0
            var strikeCount = 0
            print("숫자를 입력해주세요 : ")
            val inputNumbers = Console.readLine()

            if (inputNumbers.length != numberSize) {
                throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
            }

            for (i in 0 until numberSize) {
                if (computer[i] == inputNumbers[i].toString().toInt()) {
                    strikeCount++
                }
            }

            for (i in 0 until numberSize) {
                if (computer.contains(inputNumbers[i].toString().toInt())) {
                    if (computer[i] != inputNumbers[i].toString().toInt()) {
                        ballCount++
                    }
                }
            }

            if (ballCount > 0) {
                print("${ballCount}볼 ")
            }

            if (strikeCount > 0) {
                print("${strikeCount}스트라이크 ")
            }

            if (ballCount == 0 && strikeCount == 0) {
                print("낫싱")
            }

            println()

            if (strikeCount == numberSize) {
                break
            }
        }

        println("${numberSize}개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val restartValue = Console.readLine().toInt()

        if (restartValue == 2) {
            break
        }
    }
}
