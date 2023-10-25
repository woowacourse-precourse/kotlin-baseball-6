package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    // 야구게임 함수 호출
}

/**
 * 게임 종료 또는 새로운 게임 시작 여부를 사용자에게 물어 사용자 선택에 따라 반환하는 함수.
 *
 * @return 게임을 새로 시작할 경우 true, 종료할 경우 false
 * @throws 은 잘못된 입력값일 경우 예외를 던짐
 */
fun gameResults(inputNumber: String, numberSet: MutableSet<String>): String {
    val inputNumIdx = inputNumber.toList().map { it.toString() }
    val strike = inputNumIdx.zip(numberSet).count { (inputIdx, targetNumIdx) -> inputIdx == targetNumIdx }
    val ball = inputNumIdx.count { it in numberSet } - strike

    return when {
        strike > 0 && ball > 0 -> "${ball}볼 ${strike}스트라이크"
        strike > 0 -> "${strike}스트라이크"
        ball > 0 -> "${ball}볼"
        else -> "낫싱"
    }
}