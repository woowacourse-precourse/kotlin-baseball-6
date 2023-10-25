package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class User {
    fun trial(): String {
        print(REQUEST_INPUT_MESSAGE)
        return Console.readLine()
    }
}

class Computer{
    val computer = mutableListOf<Int>()

    fun randomAnswer(){
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

    }

    fun resetAnswer(){
        computer.clear()
    }
}