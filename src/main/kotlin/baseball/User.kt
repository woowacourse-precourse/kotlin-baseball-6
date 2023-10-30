package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    // 사용자 숫자 입력 - GameManager class의 initUser()에서 호출
    fun getNumberList(): MutableList<Int> {
        val mutableList = mutableListOf<Int>()
        val input = Console.readLine()
        isValidateInputStringForGame(input)
        input.forEach { mutableList.add(it.digitToInt()) }
        return mutableList
    }

    // 재실행 숫자 입력 - GameManager class의 finish()에서 호출
    fun getFinishNumber(): Int {
        val input = Console.readLine()
        isValidateInputStringForFinish(input)
        return input.toInt()
    }
}