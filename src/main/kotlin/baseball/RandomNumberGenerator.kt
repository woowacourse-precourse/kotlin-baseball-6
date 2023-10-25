package baseball

import camp.nextstep.edu.missionutils.Randoms

fun generateRandomNum(): MutableList<Int> {
    var computerNum: MutableList<Int> = mutableListOf()
    while (computerNum.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}


