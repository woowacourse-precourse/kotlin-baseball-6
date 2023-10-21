package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val SIZE = 3 // 리스트의 길이
    val computer = mutableListOf<String>()

    while (computer.size < SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString() // 랜덤 수 생성
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
}
