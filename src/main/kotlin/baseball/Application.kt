package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    //실행 중 여부 판단을 위한 변수
    var isRunning = true
    val randomNum = createRandomNum()

    while (isRunning) {
        print("숫자를 입력해주세요 : ")
    }
}

//서로 다른 세 수를 뽑는 Function
fun createRandomNum() : List<Int> {
    val numList = ArrayList<Int>()
    for(index in 1..3) {
        val num = Randoms.pickNumberInRange(1,9)
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }
    return numList
}
