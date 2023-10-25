package baseball

import camp.nextstep.edu.missionutils.Randoms

var computer = mutableListOf<Int>()

fun main() {
    println("숫자 야구 게임을 시작합니다.") // 1) 게임 시작 문구 출력
    while (true) { // 5) 정답이 나올 때까지 2~4번 과정 반복
        generateRandomNumber()
        playBaseballGame()
    }
}

fun generateRandomNumber() {
    computer = mutableListOf()
    while (computer.size < 3) { // 2) 1부터 9까지 3자리의 난수 생성 (컴퓨터)
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}

fun playBaseballGame() {
    val com = computer.joinToString("")
    while (true) {
        print("숫자를 입력해주세요 : ")
        var ball = 0
        var strike = 0
        val input = readLine().toString() // 3) 사용자에게 3자리 숫자를 입력 받기
        if (input.length != 3) throw IllegalArgumentException() // 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

        /* 4) 컴퓨터가 생성한 3자리 난수와 사용자가 입력한 3자리 숫자 비교하여 힌트 출력(스트라이크, 볼, 낫싱) */
        if (input == com) { // 6) 정답일 시 게임 종료 문구 출력
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        } else {
            for (i in 0..2) {
                if (com[i] == input[i]) {
                    strike++
                }
                if (input[i] in com) {
                    ball++
                }
            }
        }
        ball -= strike
        if (ball == 0 && strike == 0) {
            println("낫싱")
        } else {
            when {
                ball != 0 && strike == 0 -> println("${ball}볼")
                ball == 0 && strike != 0 -> println("${strike}스트라이크")
                else -> println("${ball}볼 ${strike}스트라이크")
            }
        }
    }
}