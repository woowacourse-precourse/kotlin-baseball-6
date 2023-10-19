package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {

}

val BASE_BALL_SIZE = 3
fun createBaseBallNumber(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < BASE_BALL_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
