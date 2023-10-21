package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO("프로그램 구현")
    println("숫자 야구 게임을 시작합니다.")
    val ComNumber = ComRandomNum()
}

// 컴퓨터가 세자리 수의 랜덤값 생성
fun ComRandomNum(): MutableList<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}