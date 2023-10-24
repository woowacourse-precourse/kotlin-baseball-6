package baseball.service

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    companion object {
        val computerNum = getRandomNum()
    }
}

fun getRandomNum(): Int {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum.joinToString("").toInt()
}