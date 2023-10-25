package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var computerNum = getRandomNum()

    fun updateNumber() {
        computerNum = getRandomNum()
    }

    private fun getRandomNum(): Int {
        val computerNum = mutableListOf<Int>()

        while (computerNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)

            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber)
            }
        }

        return computerNum.joinToString("").toInt()
    }

}
