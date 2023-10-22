package baseball

import camp.nextstep.edu.missionutils.Randoms

// 입력 및 순환 함수
fun baseBallGame() {
    // 정오답 여부
    var isAnswer = false
    // 정답 랜덤 숫자
    val answer = mutableListOf<Int>()

    // 랜덤 숫자 생성
    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }
}