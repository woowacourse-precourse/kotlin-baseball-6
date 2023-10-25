package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computer = setComputerNumber()
    println("숫자 야구 게임을 시작합니다.")
    println(computer)
    print("숫자를 입력해주세요 : ")
    val people = (readLine() ?: "").map { it.toString().toInt() }
    val set = HashSet<Int>(people)
    if (people.size != 3 || set.size < people.size) throw IllegalArgumentException("잘못된 값을 입력하셨습니다.")
    for (num in people) if (num !in 1..9) throw IllegalArgumentException("잘못된 값을 입력하셨습니다.")
}

fun setComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer




}
