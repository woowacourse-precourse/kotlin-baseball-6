package baseball

import camp.nextstep.edu.missionutils.Randoms

fun randNumber(): List<Int> {                               // 3자리 숫자 뽑는 함수
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}