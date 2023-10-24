package baseball

import baseball.model.Baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun inputGuessNum(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val inputNum = Console.readLine()
        if (inputNum != null && inputNum.length == 3) {
            val guessList = inputNum.map { it.toString().toInt() }
            if (guessList.distinct().size == 3) {
                println(guessList)
                return guessList
            }
        }
        throw IllegalArgumentException()
    }


    fun generateRandomNum(): MutableList<Int> {
        var randomList = mutableListOf<Int>();
        while (randomList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber)
            }
        }
        println(randomList)
        return randomList
    }
}