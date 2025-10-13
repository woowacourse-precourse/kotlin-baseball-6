package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


object GameConstants {

    const val NUMBER_LENGTH = 3
    const val START = "숫자 야구 게임을 시작합니다."
    const val INPUT = "숫자를 입력해주세요 : "
    const val END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"

    // 게임에 사용될 상수들
}

private class Computer {

    val randomNumberList = mutableListOf<Int>()
    // 3개의 랜덤 번호를 담을 리스트 생성

    init {
        // init을 사용하여 객체가 생성되자마자 실행됨

        while (randomNumberList.size != GameConstants.NUMBER_LENGTH) {
            // 랜덤 번호 리스트 크기가 3이 될 때까지 반복

            val pickNumber = Randoms.pickNumberInRange(1, 9)


            if (randomNumberList.contains(pickNumber)) {
                // 상위에서 선택된 랜덤 번호가 리스트에 포함되어 있는지 여부 확인

            } else {
                randomNumberList.add(pickNumber)
                // 중복이 아닐 경우만 리스트에 추가

            }
        }
    }
}

private class Player {
    // 플레이어 번호 입력받는 클래스

    fun guessNumber(): String {

        println(GameConstants.INPUT)

        return Console.readLine()

    }
}

private class InputValidator {
    // 입력받은 플레이어 번호 검증 클래스

    fun readAndValidatePlayerNumber(input: String) {

        if (input.length != GameConstants.NUMBER_LENGTH) {

            throw IllegalArgumentException()
            // 플레이어 번호 3자리가 아니면 예외 처리
        }

        if (input.toIntOrNull() == null) {

            throw IllegalArgumentException()
            // 플레이어 번호가 숫자가 아니면 예외 처리
        }

        if (input.toSet().size != GameConstants.NUMBER_LENGTH) {

            throw IllegalArgumentException()
            // 플레이어 번호에 중복된 숫자가 있으면 예외 처리

        }
    }
}

// 게임 진행
private class Baseball(private val player: Player, private val validator: InputValidator) {
    // 결합력을 줄이기 위해 플레이어와 입력검증을 외부로부터 인자를 전발 받음

    fun playGame() {

        println(GameConstants.START)
        // 게임 시작 문구 출력

        loop@ while (true) {

            val computer = Computer().randomNumberList.joinToString("")
            // 먼저 컴퓨터 랜덤 번호를 생성하고 시작

            while (true) {

                val playerInput = player.guessNumber()
                // 플레이어 번호 입력

                validator.readAndValidatePlayerNumber(playerInput)
                // 입력받은 플레이어 번호 검증

                var strikeCnt = 0
                var ballCnt = 0
                // 스트라이크와 볼의 카운트 초기화

                // 각 자리수를 비교하여 스트라이크와 볼카운트를 증가 시킴
                for (i in 0..2) {
                    for (j in 0..2) {
                        if (computer[i] == playerInput[j]) {
                            if (i == j) {
                                strikeCnt++
                            } else {
                                ballCnt++
                            }
                        }
                    }
                }

                if (strikeCnt == GameConstants.NUMBER_LENGTH) {

                    println("${strikeCnt}스트라이크")
                    println(GameConstants.END)
                    // 3스트라이크가 출력될 경우 게임 종료

                    break

                } else if (strikeCnt != 0 && ballCnt != 0) {
                    // 스트라이크,볼이 0이 아닐 경우 각각 카운트 출력

                    println("${ballCnt}볼 ${strikeCnt}스트라이크")

                } else if (strikeCnt == 0 && ballCnt == 0) {
                    // 모두 0일 경우 낫싱 출력

                    println("낫싱")

                } else if (strikeCnt != 0) {
                    // 스트라이크와 볼 중에 0이 있다면 제외하고 카운트 출력

                    println("${strikeCnt}스트라이크")

                } else {

                    println("${ballCnt}볼")
                }

            }

            // 게임 재시작 여부
            println(GameConstants.RESTART)
            // 게임 재시작 문구 출력

            val newGameInput = Console.readLine().toIntOrNull()
            // 재시작 여부를 입력받아서 정수나 null로 변환

            // 입력값이 1일 경우 continue@loop를 통해 재시작, null 일 경우 게임 종료
            if (newGameInput == 1) {
                continue@loop
            } else break
        }
    }
}


fun main() {

    val player = Player()
    val validator = InputValidator()
    Baseball(player, validator).playGame()

}
