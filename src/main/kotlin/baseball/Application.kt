package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer: List<Int> = generateRandomThreeNumber()
}

/*
    기능1. 랜덤숫자 3개 생성
    : 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
 */
fun generateRandomThreeNumber(): List<Int> {
    val randomList = mutableListOf<Int>()

    while (randomList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber)
        }
    }

    return randomList
}
