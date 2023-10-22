package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3

    private val numList: ArrayList<Int> = arrayListOf()
    private var userNumList: ArrayList<Int> = arrayListOf()

    fun initRandomNumbers(): NumberBaseball {
        while (numList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numList.contains(randomNumber)) numList.add(randomNumber)
        }

        return this
    }

    fun getUserInput(): NumberBaseball {
        try {
            userNumList = Console.readLine()
                .convertInputToNumbers()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 잘못된 입력 값입니다.")
        }

        return this
    }


    // 사용자의 입력을 Int로 바꿔 ArrayList에 담는다.
    private fun String.convertInputToNumbers(): ArrayList<Int> {
        val tempList = arrayListOf<Int>()
        this.forEach {
            if ((it in '1'..'9') && !tempList.contains(it.digitToInt())) { // 중복된 숫자를 허용하지 않는다.
                tempList.add(it.digitToInt())
                return@forEach
            }
            if (it != ' ' && it != '\t') throw IllegalArgumentException() // 공백과 탭 문자는 무시한다.
        }
        if (tempList.size != NUM_LENGTH) throw IllegalArgumentException() // 리스트에 담긴 숫자가 NUM_LENGTH가 아니면 예외처리한다.

        return tempList
    }

}