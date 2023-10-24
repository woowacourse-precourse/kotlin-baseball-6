package baseball
// 필요한 라이브러리 import
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    // 시작 문구 출력(함수 사용)
    printStartMessage()
    // println("숫자 야구 게임을 시작합니다.")

    // 컴퓨터가 생성하는 서로 다른 3자리 난수(함수 사용)
    val computer = generateRandomNumber()
    /*
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    */

    // 생성된 난수를 출력
    println(computer)

    var userInput = inputThreeNumbers()
    println("userInput: $userInput")
}

