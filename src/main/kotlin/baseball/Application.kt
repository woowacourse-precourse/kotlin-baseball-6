package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNum = pickNumberInRange(1, 9)
        if (!answer.contains(randomNum)) {
            answer.add(randomNum)
        }
    }

}
