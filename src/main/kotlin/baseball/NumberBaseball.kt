package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3

    private val numList: ArrayList<Int> = arrayListOf()
    private var userInputList: ArrayList<Int> = arrayListOf()

    fun test() {
        println(numList)
    }

    fun initRandomNumbers(): NumberBaseball {
        while (numList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numList.contains(randomNumber)) numList.add(randomNumber)
        }
        return this
    }

    fun getUserInput(): NumberBaseball {
        try {
            userInputList = Console.readLine()
                .convertInputToDigit()
            println(userInputList)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return this
    }

    private fun String.convertInputToDigit(): ArrayList<Int> {
        val tempList = arrayListOf<Int>()
        this.forEach {
            when (it) {
                in '1'..'9' -> tempList.add(it.digitToInt())
                ' ', '\t' -> {}
                else -> throw IllegalArgumentException("[ERROR] 잘못된 입력 값입니다.")
            }
        }
        tempList.distinct()
        if (tempList.size != NUM_LENGTH) throw IllegalArgumentException("[ERROR] 숫자는 세 자리여야 합니다.")

        return tempList
    }

}