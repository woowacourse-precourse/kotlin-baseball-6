package baseball.domain

import camp.nextstep.edu.missionutils.Console

class User {
    companion object {
        val userNum = userInputNum()
    }
}

fun userInputNum(): Int {
    print("숫자를 입력하세요: ")
    return Console.readLine().toInt()
}