package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    private var num = mutableListOf<Int>()

    fun getUserInput() {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        checkInput(input)
    }

    private fun checkInput(input: String) {
        if (input.length == 3) {
            for (i in 0..2) {
                val currentNum = input[i] - '0'
                if (currentNum in 1..9) {
                    if (!num.contains(currentNum)) {
                        num.add(currentNum)
                    } else throw IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해야 합니다.")
                } else throw IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해야 합니다.")
            }
        } else throw IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해야 합니다.")
    }

    fun getNum(): MutableList<Int> {
        return num
    }

    fun clear() {
        num.clear()
    }
}