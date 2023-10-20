package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf as mutableListOf

fun main() {
    startGame()
}

fun startGame() {
    println("숫자 야구 게임을 시작합니다.")
    return computerNumber()
}

fun computerNumber() {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return userNumber()
}

fun userNumber() {

}



