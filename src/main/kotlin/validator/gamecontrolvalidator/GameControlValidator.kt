package validator.gamecontrolvalidator

interface GameControlValidator {
    fun isValidate(oneOrTwo: String): Boolean
    fun isOneOrTwo(oneOrTwo: String): Boolean
}