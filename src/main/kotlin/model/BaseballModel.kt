package model

import camp.nextstep.edu.missionutils.Randoms
import constants.Constant.COUNT
import constants.Constant.END_INCLUSIVE
import constants.Constant.START_INCLUSIVE

class BaseballModel {
    val answer = IntArray(COUNT)  // 정답 저장할 배열

    fun setGame() {
        // 랜덤한 수를 answer 배열에 저장해 게임의 정답을 셋팅
        for(i in 0 until COUNT) {
            answer[i] = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
        }
    }

    fun checkAnswer(userInput: IntArray): Pair<Int, Int> {
        // 사용자가 입력한 수를 정답에 맞춰 검증
        var strike = 0
        var ball = 0

        for(i in 0 until COUNT) {
            if (answer[i] == userInput[i]) strike++  // 정답 배열과 사용자입력값 배열의 인덱스를 비교했을 때 값이 같으면 스트라이크
            else if (userInput[i] in answer) ball++  // 사용자입력값 배열의 값이 정답 배열에 있으면 볼
        }

        return Pair(strike, ball)
    }
}
