package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private const val START_INCLUSIVE = 1    // 1부터
private const val END_INCLUSIVE = 9    // 9까지
private const val COUNT = 3    // 3자리 수를 맞추는 게임

val answer = IntArray(COUNT) // 정답 저장할 배열

fun run() {
    try {
        setGame()
        playGame()
    } catch (e: IllegalArgumentException){
        throw IllegalArgumentException("올바르지 않은 입력값입니다.", e)
    }
}

private fun setGame() {
    // 랜덤한 수를 answer 배열에 저장해 게임의 정답을 셋팅함
    for(i in 0 until COUNT) { answer[i] = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) }
}

private fun playGame(){
    val userInput: IntArray = getUserNumber()
}

private fun getUserNumber(): IntArray {
    print("숫자를 입력해주세요 : ")
    val readLine = Console.readLine().split("").drop(1).dropLast(1)    // split함수의 시작과 끝에 추가되는 빈 문자열 제거
    return readLine.map { it.toInt() }.toIntArray()    // 사용자 입력값을 정수형 배열로 변환해서 반환함
}
