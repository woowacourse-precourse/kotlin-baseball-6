package validator.gamecontrolvalidator

object GameControlValidatorImpl: GameControlValidator {
    private const val ONE = "1"
    private const val TWO = "2"

    override fun isValidate(oneOrTwo: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isOneOrTwo(oneOrTwo: String): Boolean {
        require(oneOrTwo == ONE || oneOrTwo == TWO)

        return true
    }
}