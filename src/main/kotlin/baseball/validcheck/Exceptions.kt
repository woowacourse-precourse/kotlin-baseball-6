package baseball.validcheck

class Exceptions {

    fun inputNumberException(input: String) {
        val inputSet = input.toSet()

        when {
            inputSet.size < 3 -> throw IllegalArgumentException()
            input.length > 3 -> throw IllegalArgumentException()
            isNotNumber(input) -> throw IllegalArgumentException()
        }
    }

    private fun isNotNumber(input: String): Boolean {
        return !("[1-9]{3}".toRegex()
            .matches(input))
    }
}