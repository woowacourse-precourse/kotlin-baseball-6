package baseball

import camp.nextstep.edu.missionutils.Randoms

private const val START_INCLUSIVE = 1    // 1부터
private const val END_INCLUSIVE = 9   // 9까지
private const val COUNT = 3   // 3자리 수를 맞추는 게임

val answer = IntArray(COUNT) // 정답 저장할 배열

fun run() {
    setGame()
}

private fun setGame() {
    // 랜덤한 수를 answer 배열에 저장해 게임의 정답을 셋팅함
    for(i in 0 until COUNT) { answer[i] = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) }
}
