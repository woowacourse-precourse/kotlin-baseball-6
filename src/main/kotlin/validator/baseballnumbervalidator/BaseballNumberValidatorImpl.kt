package validator.baseballnumbervalidator

object BaseballNumberValidatorImpl: BaseballNumberValidator {
    private const val BASEBALL_NUMBER_SIZE = 3

    override fun isValidate(baseballNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isThreeLetters(baseballNumber: String): Boolean {
        require(baseballNumber.length == BASEBALL_NUMBER_SIZE)
        
        return true
    }

    override fun isItANumber(baseballNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun allThreeLettersDifferent(baseballNumber: String): Boolean {
        TODO("Not yet implemented")
    }
}