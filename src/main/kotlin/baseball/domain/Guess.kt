package baseball.domain

class Guess(numbers: List<BallNumber>) : BallNumbers(numbers) {

    fun getAt(index: Int) =
            numbers[index]
}