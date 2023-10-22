package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class AnswerCreator {
    fun create(): Answer {
        // 자동으로 중복 제거해주는 Set
        val set = mutableSetOf<BallNumber>()

        // Set에 숫자 3개가 들어갈 때까지
        while (set.size < BallNumbers.BALL_COUNT) {
            set.add(BallNumber(pickRandomNumber()))
        }

        return Answer(set.toList())
    }

    // 1~9 사이의 랜덤 생성 숫자 생성
    private fun pickRandomNumber() = Randoms.pickNumberInRange(1, 9)

}