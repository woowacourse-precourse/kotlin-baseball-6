package baseball

import camp.nextstep.edu.missionutils.Randoms

import camp.nextstep.edu.missionutils.Console

fun main() {
    // GameStart
    println("숫자 야구 게임을 시작합니다.")


    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    while (true) {
        println("숫자를 입력해주세요 :")
        val userInput = Console.readLine()

        // 사용자 입력값이 null 또는 3자리 숫자가 아닌 경우 예외 처리
        if (userInput == null || userInput.length != 3) {
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        }

        // 사용자 입력값을 정수 리스트로 변환
        val userNumbers = userInput.map { it.toString().toInt() }

        // 사용자 입력값이 중복된 숫자를 포함하고 있는지 확인
        if (userNumbers.toSet().size != userNumbers.size) {
            throw IllegalArgumentException("중복된 숫자가 포함되어 있습니다.")
        }

        // 결과 계산
        var strikes = 0
        var balls = 0

        for (i in 0 until 3) {
            if (computer[i] == userNumbers[i]) {
                strikes++
            } else if (computer.contains(userNumbers[i])) {
                balls++
            }
        }

        // 결과 출력
        if (strikes == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else if (strikes == 0 && balls == 0) {
            println("낫싱")
        } else {
            println("$balls 볼 $strikes 스트라이크")
        }
    }


}
