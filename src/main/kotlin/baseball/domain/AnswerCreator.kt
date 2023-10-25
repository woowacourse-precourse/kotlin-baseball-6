package baseball.domain

import baseball.util.NumberPicker

class AnswerCreator(private val numberPicker: NumberPicker) {
    fun create(): Answer {
        // 자동으로 중복 제거해주는 Set
        val set = mutableSetOf<BallNumber>() as LinkedHashSet

        // Set에 숫자 3개가 들어갈 때까지
        while (set.size < BallNumbers.BALL_COUNT) {
            set.add(BallNumber(numberPicker.pick()))
        }

        return Answer(set.toList())
    }
}