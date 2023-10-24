package baseball.model

class Answer(private val numbers: List<Int>): List<Int> by numbers {

    constructor(input: String) : this(input.toIntList())

    companion object {
        fun String.toIntList(): List<Int> {
            Validator.validAnswer(this)
            return this.map { char -> char.digitToInt() }
        }
    }
}