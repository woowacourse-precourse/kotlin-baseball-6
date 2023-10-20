package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }

    }
    println("랜덤 숫자: "+computer)
    print("숫자를 입력해주세요 : ")
    val num = Console.readLine()
    //val num_list = mutableListOf<Int>()
    val num_list = num.map { it.toString().toInt() }.toMutableList()
    println("asdf: " + num_list)

}
