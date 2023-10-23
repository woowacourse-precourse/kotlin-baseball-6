package baseball.model

class RetryNumberGenerator(private val inputText: String):NumberGenerator{
    init {
        val isOneOrTwo = inputText.matches(ONE_TO_TWO_REGEX.toRegex())
        val isCorrectCnt = RETRY_NUMBER_SIZE == inputText.length
        require(isCorrectCnt && isOneOrTwo){ println()}
    }
    override fun generator(): Int {
        return inputText.toInt()
    }

    companion object{
        const val ONE_TO_TWO_REGEX = "[1-2]"
        const val RETRY_NUMBER_SIZE = 1
    }
}