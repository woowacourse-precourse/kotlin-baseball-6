package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    // 무한번 질문을 위한 무한 반복문
    while (true) {
        val computer = mutableListOf<Int>()

        // computer에 랜덤한 값 입력할 코드
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        var strike = 0  // 위치, 숫자 모두 맞음
        var ball = 0    // 위치만 맞음
        var out = 0     // 위치, 숫자 모두 틀림

        print("숫자를 입력해주세요 : ")
        val myAnswer = readLine()?.map { e -> e.toString().toInt()}?.toIntArray()?.toMutableList()

        // 3개의 숫자를 입력하지 않은 경우
        if (myAnswer?.size != 3) {
            throw IllegalArgumentException("3개의 숫자를 입력하세요")
        }

        // 중복된 숫자를 입력한 경우
        if (myAnswer.toSet().size != 3) {
            throw IllegalArgumentException("서로 다른 숫자를 입력하세요")
        }

        // 숫자 0을 입력할 경우
        for (i in 0..2) {
            if (myAnswer[i] == 0) {
                throw IllegalArgumentException("1~9의 숫자를 입력하세요")
            }
        }

        for (i in 0..2) {
            if (myAnswer[i] == computer[i]) { // 위치가 같고 숫자가 존재할 경우
                strike++
            } else if (myAnswer[i] in computer) {  // 위치는 다르나 숫자가 존재할 경우
                ball++
            } else {
                out++
            }
        }

        // 답 출력
        if (out == 3) {
            println("낫싱")
        } else {
            if (ball >= 1) {
                print("${ball}볼 ")
            }
            if (strike >= 1) {
                println("${strike}스트라이크")
            } else {    // strike == 0일 경우 \n이 발생하지 않는 상황 제거
                println()
            }
        }

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val restart = readlnOrNull()
            if (restart == "1") {   // 게임 다시 시작
                continue
            } else if (restart == "2") {    // 게임 종료
                break
            } else {    // 숫자 1,2를 입력하지 않은 경우
                throw IllegalArgumentException("1 또는 2를 입력하세요")
            }
        }

    }
}
