package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var  numbers : MutableList<Int>
    fun makeRandomNumbers() {
        numbers = mutableListOf()
        while (numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber)
        }
    }
    fun getNumber() = numbers
}