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

    //(게임 플레이어) 서로 다른 3개의 숫자를 입력한다.
    println("숫자 야구 게임을 시작합니다.")
    println("숫자를 입력해주세요 : ")
    val input = readlnOrNull()
    var player: List<String> = emptyList<String>()

    // 입력 받은 값이 null인지, 자연수인지 확인한다.
    if (!input.isNullOrEmpty() && isInteger(input) && input.toInt() > 0){
        player = input.split("")
    }
    else {
        throw IllegalArgumentException("null이거나 자연수가 아닙니다.")
    }

    // 입력 받은 값이 서로 다른 세 자리 수인지 확인하다.
    if (player.size == 5){
        if (player[1] == player[2] || player[1] == player[3] || player[2] == player[3]){
            throw IllegalArgumentException("서로 다른 숫자가 아닙니다.")
        }
    } else {
        throw IllegalArgumentException("세 자리 숫자가 아닙니다.")
    }

    println(computer)
    println(player)

}


fun isInteger(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}