package baseball
import camp.nextstep.edu.missionutils.*

fun main() {

    // (컴퓨터) 1~9까지 서로 다른 임의의 수 3개를 선택한다.
    val computer: MutableList<Int> = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }



}
