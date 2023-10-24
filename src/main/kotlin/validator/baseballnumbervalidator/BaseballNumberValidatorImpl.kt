package validator.baseballnumbervalidator

object BaseballNumberValidatorImpl: BaseballNumberValidator {
    private const val BASEBALL_NUMBER_SIZE = 3
    private const val BASEBALL_MINIMUM_NUMBER = '1'
    private const val BASEBALL_MAXIMUM_NUMBER = '9'

    override fun isValidate(baseballNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isThreeLetters(baseballNumber: String): Boolean {
        require(baseballNumber.length == BASEBALL_NUMBER_SIZE)

        return true
    }

    override fun isItANumber(baseballNumber: String): Boolean {
        require(baseballNumber.toCharArray().all { it in BASEBALL_MINIMUM_NUMBER..BASEBALL_MAXIMUM_NUMBER })

        return true
    }

    override fun allThreeLettersDifferent(baseballNumber: String): Boolean {
        TODO("Not yet implemented")
    }
}