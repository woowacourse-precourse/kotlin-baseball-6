package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gamePlay()
}
//야구 게임 진행
fun gamePlay() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = makeComputerNumber()
    println("${computer[0]} ${computer[1]} ${computer[2]}")
}

//컴퓨터의 수를 생성하는 함수
fun makeComputerNumber() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

