package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    // 랜덤한 3개의 숫자 생성
    val computer = createNumber()
    
}

//컴퓨터가 랜덤한 3개의 숫자를 생성하는 함수
// 입력 : X
// 출력 : 랜덤한 숫자 3개가 담긴 MutableList<Int>
fun createNumber () :MutableList<Int> {
    val computer :MutableList<Int>  = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}


