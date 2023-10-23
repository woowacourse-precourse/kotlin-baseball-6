package baseball

import camp.nextstep.edu.missionutils.Randoms

const val MIN = 1
const val MAX = 9
const val SIZE = 3

class RandomNumberInit {
    fun GetRandomNumber(): String{
        val computer = mutableListOf<Int>()
        while (computer.size < SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN, MAX)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString ("")
    }
}