package baseball

import camp.nextstep.edu.missionutils.Randoms

import camp.nextstep.edu.missionutils.Console

fun main() {
    // Game Start
    println("숫자 야구 게임을 시작합니다.")

    /*
    게임세팅
     */

    // 컴퓨터가 생각하는 3자리 수 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        //중복된 숫자가 없도록 에외처리
        if (!computer.contains(randomNumber)) {//컴퓨터리스트에 중복된번호가 포함되어있지 않을때!
            computer.add(randomNumber)
        }
    }

    try {
        // 사용자 입력 받기
        print("숫자를 입력해주세요: ")
        val userInput = Console.readLine()

        // userInput을 숫자로 변환하여 사용
        val userNumbers = userInput.map { it.toString().toInt() }

        println("입려한 값 ${userNumbers}")

    } catch (e: IllegalArgumentException) {
        // 잘못된 값 입력 시 예외 처리
        println("잘못된 입력입니다. 프로그램을 종료합니다.")
        return
    }

}
