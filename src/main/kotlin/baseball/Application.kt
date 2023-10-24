package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun getComputerNumList(): MutableList<Int> {
    val computerNumList = mutableListOf<Int>()
    while (computerNumList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumList.contains(randomNumber)) {
            computerNumList.add(randomNumber)
        }
    }
    return computerNumList
}
