package baseball

import camp.nextstep.edu.missionutils.Randoms

// 서로 다른 3자리의 난수 리스트를 생성하여 반환
fun generateRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}