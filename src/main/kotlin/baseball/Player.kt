package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Player {
    fun trial(): String {
        print(REQUEST_INPUT_MESSAGE)
        return Console.readLine()
    }
}

class Computer {
    val answer = mutableListOf<Int>()

    fun generateAnswer() {
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
                print(randomNumber)
            }
        }
    }

    fun resetAnswer() {
        answer.clear()
    }

}