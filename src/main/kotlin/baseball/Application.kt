package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf


fun main() {
    // 3자리 랜덤 숫자 생성
    // computer[0]은 첫번째 자리 [2]는 세번째 자리
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

   
}
