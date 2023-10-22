package baseball

import camp.nextstep.edu.missionutils.Randoms

import camp.nextstep.edu.missionutils.Console

fun main() {
    // Game Start
    println("숫자 야구 게임을 시작합니다.")

    // 컴퓨터가 생각하는 3자리 수 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        //중복된 숫자가 없도록 에외처리
        if (!computer.contains(randomNumber)) {//컴퓨터리스트에 중복된번호가 포함되어있지 않을때!
            computer.add(randomNumber)
        }
    }
    

}
