package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNum = pickNumberInRange(1, 9)
        if (!answer.contains(randomNum)) {
            answer.add(randomNum)
        }
    }

    // B: 사용자의 수를 입력받는다.
    print("숫자를 입력해주세요 : ")
    val input = readLine()

    // B-2 유효성 검증
    if (input.length != 3) {
        throw IllegalArgumentException("입력한 수가 3자리가 아닙니다.")
    }
    if (input.contains("""[^123456789]""".toRegex())) {
        throw IllegalArgumentException("유효하지 않은 형식입니다.")
    }

    val numSet = input.toCharArray().toSet()
    if (numSet.size < 3) {
        throw IllegalArgumentException("중복된 수를 가집니다.")
    }


}
