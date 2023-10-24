package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer = mutableListOf<Int>()

    // computer에 랜덤한 값 입력할 코드
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println(computer.toString())
    // 무한번 질문을 위한 무한 반복문
    while (true) {
        var strike = 0  // 위치, 숫자 모두 맞음
        var ball = 0    // 위치만 맞음
        var out = 0     // 위치, 숫자 모두 틀림

        print("숫자를 입력해주세요 : ")
        val myAnswer = readLine()?.map { e -> e.toString().toInt()}?.toIntArray()?.toMutableList()!!

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
            break
        }
    }
}
