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

    fun countStrike(computer: List<Int>, user: List<Int>) : Int {
        var count = 0
        for (i in 0..INPUT_SIZE-1) {
            if (computer[i] == user[i]) count++
        }
        return count
    }
}