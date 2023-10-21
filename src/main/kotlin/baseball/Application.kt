package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    // 시작 안내 문구 출력
    println("숫자 야구 게임을 시작합니다.")

    // 1부터 9까지의 서로 다른 랜덤 숫자 3개 뽑기
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}
