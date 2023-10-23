package baseball

import baseball.utils.Utils

class Baseball {
    fun run(computer: List<Int>) {
        while (true) {
            val user = getPlayerNumber()
        }
    }

    fun getPlayerNumber() : List<Int> {
        print("숫자를 입력해주세요 : ")
        val userNumber = readLine()
        return Utils().checkInput(userNumber!!)
    }
}