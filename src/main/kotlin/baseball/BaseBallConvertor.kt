package baseball

class BaseBallConvertor(private val ballsValidator: BaseBallsValidator = BaseBallsValidator()) {
    fun convert(numbers: String): List<Int> {
        val baseBalls = try {
            numbers.map { it.toString().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
        ballsValidator.validate(baseBalls)
        return baseBalls
    }
}