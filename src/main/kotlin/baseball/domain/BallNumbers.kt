package baseball.domain


// BallNumbers를 상속 받을 Guess, Answer에서 모두 필요
// BallNumbers의 자식에서만 호출할 것이기 때문에 protected
abstract class BallNumbers(protected val numbers: List<BallNumber>) {

    init {
        validateNumbersLength(numbers)
    }

    companion object {

        const val BALL_COUNT = 3

        private fun validateNumbersLength(numbers: List<BallNumber>) {
            if (numbers.size != BALL_COUNT) {
                throw IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.")
            }
        }
    }

}
