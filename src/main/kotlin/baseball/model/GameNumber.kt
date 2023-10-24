package baseball.model

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun createNum(): String {
    val computer = mutableListOf<String>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber.toString())) {
            computer.add(randomNumber.toString())
        }
    }

    val answer = computer.joinToString("")

    return answer
}

fun input(): String {
    return Console.readLine()
}
