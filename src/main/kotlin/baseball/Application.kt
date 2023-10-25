package baseball

import camp.nextstep.edu.missionutils.Randoms

var computer = mutableListOf<Int>()

fun main() {
    println("숫자 야구 게임을 시작합니다.") // 1) 게임 시작 문구 출력
    while (true) {
        generateRandomNumber()
    }
}

fun generateRandomNumber() { // 2) 1부터 9까지 3자리의 난수 생성 (컴퓨터)
    computer = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}