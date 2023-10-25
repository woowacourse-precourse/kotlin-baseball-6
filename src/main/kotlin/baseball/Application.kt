package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")


}

fun playGame() {


}

fun genAnswer() : String {
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }
    return answer.joinToString("")

}