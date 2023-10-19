package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf


fun main() {
    // 3자리 랜덤 숫자 생성
    // computer[0]은 첫번째 자리 [2]는 세번째 자리
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")
    val num = Console.readLine()
    readNumber(num)
}

// 입력 유효성 확인
fun readNumber(num: String): Int {
    try {
        val validNum = num.toInt()
        if (num.length != 3) {
            throw IllegalArgumentException("숫자는 3자리여야 합니다. ")
        }
        return validNum
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자를 입력해 주세요")
    }
}
