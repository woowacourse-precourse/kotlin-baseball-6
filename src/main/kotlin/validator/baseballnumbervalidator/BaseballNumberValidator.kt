package validator.baseballnumbervalidator

interface BaseballNumberValidator {
    fun isValidate(baseballNumber: String): Boolean
    fun isThreeLetters(baseballNumber: String): Boolean
    fun isItANumber(baseballNumber: String): Boolean
    fun allThreeLettersDifferent(baseballNumber: String): Boolean
}