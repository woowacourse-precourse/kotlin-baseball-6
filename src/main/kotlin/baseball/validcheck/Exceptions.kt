package baseball.validcheck

class Exceptions {

    fun inputNumberException(input: String) {
        val inputSet = input.toSet()

        if (inputSet.size != 3){
            throw IllegalArgumentException()
        } else if (isNotNumber(input)){
            throw IllegalArgumentException()
        }
    }

    private fun isNotNumber(input: String): Boolean {
        return !("[1-9]{3}".toRegex()
            .matches(input))
    }
}