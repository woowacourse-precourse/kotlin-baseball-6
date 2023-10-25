package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val computer = generateRandomNumber()
        var attempts = 0
}
    
fun generateRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    return input.map { it.toString().toInt() }
}

