package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun inputGuessNum(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val inputNum = Console.readLine()
        val numberValidation = NumberValidation()
        numberValidation.validation(inputNum)
        val guessList = inputNum.map { it.toString().toInt() }
        numberValidation.validation(guessList)
        return guessList
    }
    fun generateRandomNum(): MutableList<Int> {
        val randomList = mutableListOf<Int>()
        while (randomList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber)
            }
        }
        return randomList
    }
}